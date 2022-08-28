package com.henrique.openbrewery.features.brewerylist.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.henrique.datasource.ui.base.BaseViewModel
import com.henrique.datasource.brewerylist.domain.interfaces.repository.BreweryListRepository
import com.henrique.datasource.domain.model.Brewery
import com.henrique.datasource.data.ResultStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryListViewModel(private val breweryListRepository: BreweryListRepository) : BaseViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val breweryListLiveData = MutableLiveData<ResultStatus<List<Brewery>>>()

    fun getBreweryList() {
        breweryListLiveData.postValue(ResultStatus.Loading)
        viewModelScope.launch {
            breweryListLiveData.postValue(breweryListRepository.getBreweryList())
        }
    }
}