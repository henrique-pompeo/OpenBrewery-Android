package com.henrique.openbrewery.brewerylist.domain.model

internal class BreweryListItem(
    val id: String,
    val name: String?,
    val address: BreweryAddress,
    val phone: String?,
    val type: String?
)
