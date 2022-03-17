package com.henrique.brewerydetail.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.henrique.brewerydetail.data.repository.BreweryDetailRepository
import com.henrique.shared.data.ResultStatus
import com.henrique.shared.domain.model.Brewery
import com.henrique.shared.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryDetailViewModel(private val breweryDetailRepository: BreweryDetailRepository) :
    BaseViewModel() {

    val breweryDetailLiveData = MutableLiveData<ResultStatus<Brewery>>()

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getBreweryById(id: String) {
        breweryDetailLiveData.postValue(ResultStatus.Loading)
        viewModelScope.launch {
            breweryDetailLiveData.postValue(breweryDetailRepository.getBreweryById(id))
        }
    }
}