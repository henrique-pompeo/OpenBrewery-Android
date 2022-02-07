package com.henrique.brewerydetail.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.henrique.brewerydetail.data.repository.BreweryDetailRepository
import com.henrique.shared.data.Result
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

    val breweryDetail = MutableLiveData<Result<Brewery>>()

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getBreweryById(id: String) {
        breweryDetail.value = Result.Loading
        viewModelScope.launch {
            try {
                breweryDetail.value = Result.Success(breweryDetailRepository.getBreweryById(id))
            } catch (e: Exception) {
                breweryDetail.value = Result.Error(e)
            }
        }
    }

}