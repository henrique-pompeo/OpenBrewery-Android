package com.henrique.openbrewery.domain.brewerydetail.model

sealed class BreweryDetailState {
    data class Success(val breweryDetail: BreweryDetail): BreweryDetailState()
    object Error : BreweryDetailState()
    object Loading : BreweryDetailState()
}