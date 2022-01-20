package com.henrique.openbreweryandroid.app.feature.brewerylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.henrique.openbreweryandroid.app.base.BaseViewModel
import com.henrique.openbreweryandroid.data.repository.BreweryRepository
import com.henrique.openbreweryandroid.domain.model.Brewery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryListViewModel(private val breweryRepository: BreweryRepository) : BaseViewModel() {

    private val _breweryList = MutableLiveData<List<Brewery>>()
    val breweryList: LiveData<List<Brewery>> get() = _breweryList

    fun getBreweries() {
        CoroutineScope(Dispatchers.Main).launch {
            _breweryList.value = breweryRepository.getBreweryList()
        }
    }
}