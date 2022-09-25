package com.henrique.openbrewery.domain.brewerylist.model

import com.henrique.openbrewery.domain.brewery.model.Brewery

sealed class BreweryListState {
    data class Success(val breweryList: List<Brewery>) : BreweryListState()
    object Error : BreweryListState()
    object Loading : BreweryListState()
}