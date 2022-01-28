package com.henrique.brewerylist.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.henrique.featurecommons.ui.base.BaseViewModel
import com.henrique.brewerylist.data.repository.BreweryRepository
import com.henrique.featurecommons.domain.model.Brewery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryListViewModel(private val breweryRepository: BreweryRepository) : BaseViewModel() {

    private val _breweryList = MutableLiveData<List<Brewery>>()
    val breweryList: LiveData<List<Brewery>> get() = _breweryList

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getBreweries() {
        viewModelScope.launch {
            _breweryList.value = breweryRepository.getBreweryList()
        }
    }
}