package com.henrique.openbrewery.brewerylist.domain.model

internal sealed class BreweryListState {
    data class Success(val breweryList: List<BreweryListItemModel>): BreweryListState()
    object Error : BreweryListState()
    object Loading : BreweryListState()
}