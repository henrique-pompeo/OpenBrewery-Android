package com.henrique.openbrewery.brewerydetail.data.dto

import com.google.gson.annotations.SerializedName

internal class BreweryDetailDTO(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("brewery_type") val breweryType: String,
    @SerializedName("address_1") val address1: String?,
    @SerializedName("address_2") val address2: String?,
    @SerializedName("address_3") val address3: String?,
    @SerializedName("city") val city: String,
    @SerializedName("state_province") val stateProvince: String,
    @SerializedName("postal_code") val postalCode: String,
    @SerializedName("country") val country: String,
    @SerializedName("longitude") val longitude: Number?,
    @SerializedName("latitude") val latitude: Number?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("website_url") val websiteUrl: String?,
    @SerializedName("state") val state: String,
    @SerializedName("street") val street: String?
)
