package com.henrique.openbrewery.domain.brewerylist.model

data class BreweryAddress (
    val street: String?,
    val address2: String?,
    val address3: String?,
    val city: String?,
    val state: String?,
    val countyProvince: String?,
    val postalCode: String?,
    val country: String?
)
