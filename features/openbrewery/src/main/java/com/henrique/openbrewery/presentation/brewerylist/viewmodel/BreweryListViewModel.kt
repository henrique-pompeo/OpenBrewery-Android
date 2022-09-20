package com.henrique.openbrewery.presentation.brewerylist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.henrique.openbrewery.domain.brewerylist.model.BreweryListItem
import com.henrique.openbrewery.domain.brewerylist.model.BreweryListState
import com.henrique.openbrewery.domain.brewerylist.usecase.BreweryListUseCase
import kotlinx.coroutines.launch

class BreweryListViewModel(
    private val breweryListUseCase: BreweryListUseCase
) : ViewModel() {
    private val _breweryListState = MutableLiveData<BreweryListState>()
    val breweryListState: LiveData<BreweryListState> get() = _breweryListState

    private val _clickedBrewery = MutableLiveData<BreweryListItem>()
    val clickedBrewery: LiveData<BreweryListItem> get() = _clickedBrewery

    init {
        _breweryListState.postValue(BreweryListState.Loading)
        getBreweryList()
    }    

    fun getBreweryList() {
        viewModelScope.launch {
            _breweryListState.postValue(breweryListUseCase.getBreweryList())
        }
    }
    
    fun itemClicked(breweryListItem: BreweryListItem) {
        _clickedBrewery.postValue(breweryListItem)
    }
}
