package com.henrique.domain.model

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class Brewery(
    var id: Long,
    var name: String?,
    var brewery_type: String?,
    var street: String?,
    var address_2: String?,
    var address_3: String?,
    var city: String?,
    var state: String?,
    var county_province: String?,
    var postal_code: String?,
    var country: String?,
    var longitude: String?,
    var latitude: String?,
    var phone: String?,
    var website_url: String?,
    var updated_at: Date?,
    var created_at: Date?
)
