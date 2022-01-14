package com.henrique.openbreweryandroid.data.entity

import com.google.gson.annotations.SerializedName
import com.henrique.openbreweryandroid.domain.entity.BreweryEntity
import java.util.Date

data class BreweryEntity(
    @SerializedName("id")
    override val id: Long,
    @SerializedName("name")
    override val name: String?,
    @SerializedName("brewery_type")
    override val brewery_type: String?,
    @SerializedName("street")
    override val street: String?,
    @SerializedName("address_2")
    override val address_2: String?,
    @SerializedName("address_3")
    override val address_3: String?,
    @SerializedName("city")
    override val city: String?,
    @SerializedName("state")
    override val state: String?,
    @SerializedName("county_province")
    override val county_province: String?,
    @SerializedName("postal_code")
    override val postal_code: String?,
    @SerializedName("country")
    override val country: String?,
    @SerializedName("longitude")
    override val longitude: String?,
    @SerializedName("latitude")
    override val latitude: String?,
    @SerializedName("phone")
    override val phone: String?,
    @SerializedName("website_url")
    override val website_url: String?,
    @SerializedName("updated_at")
    override val updated_at: Date?,
    @SerializedName("created_at")
    override val created_at: Date?
) : BreweryEntity
