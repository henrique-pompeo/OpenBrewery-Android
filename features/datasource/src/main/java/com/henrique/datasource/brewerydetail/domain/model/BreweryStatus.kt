package com.henrique.datasource.brewerydetail.domain.model

sealed class BreweryStatus {
    data class Success(val breweryList: List<Brewery>) : BreweryStatus()
    data class Error(val message: String?) : BreweryStatus()
    object Loading : BreweryStatus()
}