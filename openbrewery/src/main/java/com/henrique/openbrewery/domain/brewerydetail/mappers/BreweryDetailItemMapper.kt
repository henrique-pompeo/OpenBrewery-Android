package com.henrique.openbrewery.domain.brewerydetail.mappers

import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetailItem
import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetail

class BreweryDetailItemMapper {
    fun toItem(breweryDetail: BreweryDetail): BreweryDetailItem {
        return BreweryDetailItem(
            id = breweryDetail.id,
            name = breweryDetail.name,
            breweryType = breweryDetail.breweryType,
            street = breweryDetail.street,
            address2 = breweryDetail.address2,
            address3 = breweryDetail.address3,
            city = breweryDetail.city,
            state = breweryDetail.state,
            countyProvince = breweryDetail.countyProvince,
            postalCode = breweryDetail.postalCode,
            country = breweryDetail.country,
            longitude = breweryDetail.longitude,
            latitude = breweryDetail.latitude,
            phone = breweryDetail.phone,
            websiteUrl = breweryDetail.websiteUrl,
            updatedAt = breweryDetail.updatedAt,
            createdAt = breweryDetail.createdAt
        )
    }
}
