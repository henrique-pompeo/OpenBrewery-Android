package com.henrique.openbrewery.domain.brewerylist.model

sealed class BreweryListState {
    data class Success(val breweryListItem: List<BreweryListItem>) : BreweryListState()
    object Error : BreweryListState()
    object Loading : BreweryListState()
}