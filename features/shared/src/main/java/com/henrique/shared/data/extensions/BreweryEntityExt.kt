package com.henrique.shared.data.extensions

import com.henrique.shared.data.database.entity.BreweryEntity
import com.henrique.shared.domain.model.Brewery

fun BreweryEntity.model() =
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