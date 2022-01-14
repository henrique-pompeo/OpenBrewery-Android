package com.henrique.openbreweryandroid.data.entity


import com.henrique.openbreweryandroid.domain.entity.BreweryEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class BreweryEntity(
    @Json(name = "id")
    override val id: Long,
    @Json(name = "name")
    override val name: String?,
    @Json(name = "brewery_type")
    override val breweryType: String?,
    @Json(name = "street")
    override val street: String?,
    @Json(name = "address_2")
    override val address2: String?,
    @Json(name = "address_3")
    override val address3: String?,
    @Json(name = "city")
    override val city: String?,
    @Json(name = "state")
    override val state: String?,
    @Json(name = "county_province")
    override val countyProvince: String?,
    @Json(name = "postal_code")
    override val postalCode: String?,
    @Json(name = "country")
    override val country: String?,
    @Json(name = "longitude")
    override val longitude: String?,
    @Json(name = "latitude")
    override val latitude: String?,
    @Json(name = "phone")
    override val phone: String?,
    @Json(name = "website_url")
    override val websiteUrl: String?,
    @Json(name = "updated_at")
    override val updatedAt: Date?,
    @Json(name = "created_at")
    override val createdAt: Date?
) : BreweryEntity
