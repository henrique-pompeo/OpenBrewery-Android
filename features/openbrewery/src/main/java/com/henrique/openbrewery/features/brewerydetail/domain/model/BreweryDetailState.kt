package com.henrique.datasource.datasource.brewerydetail.domain.model

sealed class BreweryDetailState {
    data class Success(val breweryDetail: BreweryDetail) : BreweryDetailState()
    data class Error(val message: String?) : BreweryDetailState()
    object Loading : BreweryDetailState()
}