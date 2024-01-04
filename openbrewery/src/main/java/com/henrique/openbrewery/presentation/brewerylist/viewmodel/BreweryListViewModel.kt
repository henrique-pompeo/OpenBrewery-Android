package com.henrique.openbrewery.presentation.brewerylist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.henrique.openbrewery.domain.brewerylist.model.BreweryListState
import com.henrique.openbrewery.domain.brewerylist.usecase.BreweryListUseCase
import kotlinx.coroutines.launch

class BreweryListViewModel(
    private val breweryListUseCase: BreweryListUseCase,
) : ViewModel() {
    private val _breweryListState = MutableLiveData<BreweryListState?>()
    val breweryListState: LiveData<BreweryListState?> get() = _breweryListState

    private val _clickedBrewery = MutableLiveData<String?>()
    val clickedBrewery: LiveData<String?> get() = _clickedBrewery

    fun getBreweryList() {
        viewModelScope.launch {
            startLoading()
            _breweryListState.postValue(breweryListUseCase.getBreweryList())
        }
    }

    fun itemClicked(id: String) {
        _clickedBrewery.postValue(id)
    }

    fun clearStates() {
        _clickedBrewery.postValue(null)
        _breweryListState.postValue(null)
    }

    private fun startLoading() {
        _breweryListState.postValue(BreweryListState.Loading)
    }
}
