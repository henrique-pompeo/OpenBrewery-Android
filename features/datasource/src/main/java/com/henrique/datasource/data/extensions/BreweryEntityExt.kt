package com.henrique.datasource.data.extensions

import com.henrique.datasource.dataprovider.providers.database.openbrewery.entity.BreweryEntity
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail

fun BreweryEntity.model() =
    BreweryDetail(
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