package com.henrique.openbrewery.features.brewerylist.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.henrique.datasource.ui.base.BaseViewModel
import com.henrique.datasource.datasource.brewerylist.domain.interfaces.repository.BreweryListRepository
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetailState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryListViewModel(private val breweryListRepository: BreweryListRepository) : BaseViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val breweryListLiveData = MutableLiveData<BreweryDetailState<List<BreweryDetail>>>()

    fun getBreweryList() {
        breweryListLiveData.postValue(BreweryDetailState.Loading)
        viewModelScope.launch {
            breweryListLiveData.postValue(breweryListRepository.getBreweryList())
        }
    }
}