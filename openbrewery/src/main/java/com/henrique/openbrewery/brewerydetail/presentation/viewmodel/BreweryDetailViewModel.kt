package com.henrique.openbrewery.brewerydetail.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.henrique.openbrewery.brewerydetail.domain.model.BreweryDetailState
import com.henrique.openbrewery.brewerydetail.domain.usecase.BreweryDetailUseCase
import kotlinx.coroutines.launch

internal class BreweryDetailViewModel(
    private val breweryDetailUseCase: BreweryDetailUseCase,
): ViewModel() {

    private val _breweryDetailState = MutableLiveData<BreweryDetailState>()
    val breweryDetailState: LiveData<BreweryDetailState> get() = _breweryDetailState

    fun getBreweryDetails(obdbId: String) {

        viewModelScope.launch {
            startLoading()
            runCatching {
                breweryDetailUseCase.getBreweryDetails(obdbId = obdbId)
            }.onSuccess {
                _breweryDetailState.postValue(BreweryDetailState.Success(it))
            }.onFailure {
                _breweryDetailState.postValue(BreweryDetailState.Error)
            }
        }
    }

    private fun startLoading() {
        _breweryDetailState.postValue(BreweryDetailState.Loading)
    }
}
