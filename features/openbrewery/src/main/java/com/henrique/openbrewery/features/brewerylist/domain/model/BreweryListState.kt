package com.henrique.openbrewery.features.brewerylist.domain.model

sealed class BreweryListState {
    data class Success(val breweryDetail: BreweryList) : BreweryListState()
    data class Error(val message: String?) : BreweryListState()
    object Loading : BreweryListState()
}