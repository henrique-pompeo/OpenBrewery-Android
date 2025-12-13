package com.henrique.openbrewery.brewerydetail.domain.model

internal sealed class BreweryDetailState {
    data class Success(val breweryDetailModel: BreweryDetailModel): BreweryDetailState()
    object Error : BreweryDetailState()
    object Loading : BreweryDetailState()
}
