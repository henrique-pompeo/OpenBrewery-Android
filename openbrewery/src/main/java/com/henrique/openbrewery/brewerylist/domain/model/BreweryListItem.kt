package com.henrique.openbrewery.brewerylist.domain.model

data class BreweryListItem(
    val id: String,
    val name: String?,
    val address: BreweryAddress?,
    val phone: String?,
    val type: String?,
    val distance: String?
)
