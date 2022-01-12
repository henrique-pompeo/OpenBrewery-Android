package com.henrique.openbreweryandroid.domain.entity

import java.util.Date

interface BreweryEntity {
    val id: Long
    val name: String?
    val brewery_type: String?
    val street: String?
    val address_2: String?
    val address_3: String?
    val city: String?
    val state: String?
    val county_province: String?
    val postal_code: String?
    val country: String?
    val longitude: String?
    val latitude: String?
    val phone: String?
    val website_url: String?
    val updated_at: Date?
    val created_at: Date?
}