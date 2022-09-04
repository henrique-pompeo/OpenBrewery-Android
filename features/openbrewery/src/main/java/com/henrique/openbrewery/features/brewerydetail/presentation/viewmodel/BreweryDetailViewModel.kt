package com.henrique.openbrewery.features.brewerydetail.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.henrique.datasource.brewerydetail.domain.interfaces.repository.BreweryDetailRepository
import com.henrique.datasource.brewerydetail.domain.model.BreweryStatus
import com.henrique.datasource.brewerydetail.domain.model.Brewery
import com.henrique.datasource.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryDetailViewModel(private val breweryDetailRepository: BreweryDetailRepository) :
    BaseViewModel() {

    val breweryDetailLiveData = MutableLiveData<BreweryStatus<Brewery>>()

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getBreweryById(id: String) {
        breweryDetailLiveData.postValue(BreweryStatus.Loading)
        viewModelScope.launch {
            breweryDetailLiveData.postValue(breweryDetailRepository.getBreweryById(id))
        }
    }
}