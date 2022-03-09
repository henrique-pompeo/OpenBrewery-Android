package com.henrique.brewerylist.ui

import androidx.lifecycle.MutableLiveData
import com.henrique.shared.ui.base.BaseViewModel
import com.henrique.brewerylist.data.repository.BreweryListRepository
import com.henrique.shared.domain.model.Brewery
import com.henrique.shared.data.ResultStatus
import com.henrique.shared.data.database.entities.BreweryEntity
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
        breweryListLiveData.value = ResultStatus.Loading
        viewModelScope.launch {
            breweryListLiveData.value = breweryListRepository.getBreweryList()
        }
    }
}