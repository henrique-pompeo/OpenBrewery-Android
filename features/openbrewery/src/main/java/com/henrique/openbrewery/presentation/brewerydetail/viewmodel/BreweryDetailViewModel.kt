package com.henrique.openbrewery.presentation.brewerydetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.repository.BreweryDetailRepository
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetailState
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class BreweryDetailViewModel(
    private val breweryDetailRepository: BreweryDetailRepository
) : ViewModel() {

    val breweryDetailLiveData = MutableLiveData<BreweryDetailState<BreweryDetail>>()

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getBreweryById(id: String) {
        breweryDetailLiveData.postValue(BreweryDetailState.Loading)
        viewModelScope.launch {
            breweryDetailLiveData.postValue(breweryDetailRepository.getBreweryDetails(id))
        }
    }
}