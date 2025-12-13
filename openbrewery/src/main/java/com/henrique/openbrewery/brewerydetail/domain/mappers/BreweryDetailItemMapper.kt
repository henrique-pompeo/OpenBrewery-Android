package com.henrique.openbrewery.brewerydetail.domain.mappers

import com.henrique.openbrewery.brewerydetail.domain.model.BreweryDetailItem
import com.henrique.openbrewery.brewerydetail.domain.model.BreweryDetailModel

internal object BreweryDetailItemMapper {
    fun toItem(breweryDetailModel: BreweryDetailModel): BreweryDetailItem {
        return BreweryDetailItem(
            id = breweryDetailModel.id,
            name = breweryDetailModel.name,
            breweryType = breweryDetailModel.breweryType,
            address1 = breweryDetailModel.address1,
            address2 = breweryDetailModel.address2,
            address3 = breweryDetailModel.address3,
            city = breweryDetailModel.city,
            stateProvince = breweryDetailModel.stateProvince,
            postalCode = breweryDetailModel.postalCode,
            country = breweryDetailModel.country,
            longitude = breweryDetailModel.longitude,
            latitude = breweryDetailModel.latitude,
            phone = breweryDetailModel.phone,
            websiteUrl = breweryDetailModel.websiteUrl,
            state = breweryDetailModel.state,
            street = breweryDetailModel.street
        )
    }
}
