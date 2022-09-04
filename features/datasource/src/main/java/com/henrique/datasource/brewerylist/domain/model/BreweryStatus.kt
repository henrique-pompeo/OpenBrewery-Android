package com.henrique.datasource.brewerylist.domain.model

sealed class BreweryStatus {
    data class Success(val brewery: Brewery) : BreweryStatus()
    data class Error(val message: String?) : BreweryStatus()
    object Loading : BreweryStatus()
}