package com.henrique.datasource.datasource.brewerydetail.domain.model

data class BreweryDetailItem(
    //TODO -- FIELDS SHOULD BE MAPPED TO UNDERSTAND EACH OF THEM WILL BE DISPLAYED
    val id: String,
    val name: String?,
    val breweryType: String?,
    val street: String?,
    val address2: String?,
    val address3: String?,
    val city: String?,
    val state: String?,
    val countyProvince: String?,
    val postalCode: String?,
    val country: String?,
    val longitude: String?,
    val latitude: String?,
    val phone: String?,
    val websiteUrl: String?,
    val updatedAt: String?,
    val createdAt: String?
)
