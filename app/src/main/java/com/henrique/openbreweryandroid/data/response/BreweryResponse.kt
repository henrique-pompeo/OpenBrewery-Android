package com.henrique.openbreweryandroid.data.response


import com.henrique.openbreweryandroid.domain.model.Brewery
import com.google.gson.annotations.SerializedName
import java.util.Date

class BreweryResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String?,
    @SerializedName("brewery_type") val breweryType: String?,
    @SerializedName("street") val street: String?,
    @SerializedName("address_2") val address2: String?,
    @SerializedName("address_3") val address3: String?,
    @SerializedName("city") val city: String?,
    @SerializedName("state") val state: String?,
    @SerializedName("county_province") val countyProvince: String?,
    @SerializedName("postal_code") val postalCode: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("longitude") val longitude: String?,
    @SerializedName("latitude") val latitude: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("website_url") val websiteUrl: String?,
    @SerializedName("updated_at") val updatedAt: Date?,
    @SerializedName("created_at") val createdAt: Date?
)

fun BreweryResponse.Model() =
    Brewery(
        id = id,
        name,
        breweryType = breweryType,
        street = street,
        address2 = address2,
        address3 = address3,
        city = city,
        state = state,
        countyProvince = countyProvince,
        postalCode = postalCode,
        country = country,
        longitude = longitude,
        latitude = latitude,
        phone = phone,
        websiteUrl = websiteUrl,
        updatedAt = updatedAt,
        createdAt = createdAt
    )
