package com.henrique.openbreweryandroid.app.feature.brewerylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.henrique.openbreweryandroid.app.base.BaseViewModel
import com.henrique.openbreweryandroid.domain.entity.BreweryEntity
import com.henrique.openbreweryandroid.domain.dataprovider.BreweryListDataProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryListViewModel(private val dataProvider: BreweryListDataProvider) : BaseViewModel() {

    private val _breweryList = MutableLiveData<List<BreweryEntity>>()
    val breweryList: LiveData<List<BreweryEntity>> get() = _breweryList

    fun getBreweries() {
        CoroutineScope(Dispatchers.Main).launch {
            _breweryList.value = dataProvider.getBreweryList()
        }
    }
}