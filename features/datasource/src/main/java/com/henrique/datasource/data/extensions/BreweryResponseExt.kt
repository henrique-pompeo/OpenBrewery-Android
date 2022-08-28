package com.henrique.datasource.data.extensions

import com.henrique.datasource.data.database.entity.BreweryEntity
import com.henrique.datasource.data.remote.response.BreweryResponse
import com.henrique.datasource.domain.model.Brewery

fun BreweryResponse.model() =
    Brewery(
        id = id,
        name = name,
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

fun BreweryResponse.toEntity() =
    BreweryEntity(
        id = id,
        name = name,
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