package com.henrique.openbreweryandroid.domain.entity

import java.util.Date

interface BreweryEntity {
    val id: Long
    val name: String?
    val breweryType: String?
    val street: String?
    val address2: String?
    val address3: String?
    val city: String?
    val state: String?
    val countyProvince: String?
    val postalCode: String?
    val country: String?
    val longitude: String?
    val latitude: String?
    val phone: String?
    val websiteUrl: String?
    val updatedAt: Date?
    val createdAt: Date?
}