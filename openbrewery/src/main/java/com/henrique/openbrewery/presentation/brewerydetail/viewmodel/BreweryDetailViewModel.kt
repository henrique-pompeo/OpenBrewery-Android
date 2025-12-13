package com.henrique.openbrewery.presentation.brewerydetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetailState
import com.henrique.openbrewery.domain.brewerydetail.usecase.BreweryDetailUseCase
import kotlinx.coroutines.launch

class BreweryDetailViewModel(
    private val breweryDetailUseCase: BreweryDetailUseCase,
): ViewModel() {
    private val _breweryDetailState = MutableLiveData<BreweryDetailState>()
    val breweryDetailState: LiveData<BreweryDetailState> get() = _breweryDetailState

    init {
        _breweryDetailState.postValue(BreweryDetailState.Loading)
    }

    fun getBreweryDetails(id: String) {
        viewModelScope.launch {
            _breweryDetailState.postValue(breweryDetailUseCase.getBreweryDetails(id = id))
        }
    }
}
