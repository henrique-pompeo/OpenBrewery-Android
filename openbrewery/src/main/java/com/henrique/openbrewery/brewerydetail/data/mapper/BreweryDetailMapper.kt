package com.henrique.openbrewery.brewerydetail.data.mapper

import com.henrique.openbrewery.brewerydetail.data.dto.BreweryDetailDTO
import com.henrique.openbrewery.brewerydetail.domain.model.BreweryDetailModel

internal object BreweryDetailMapper {

    fun toDomain(breweryDetailDTO: BreweryDetailDTO): BreweryDetailModel {
        return BreweryDetailModel(
            id = breweryDetailDTO.id,
            name = breweryDetailDTO.name,
            breweryType = breweryDetailDTO.breweryType,
            address1 = breweryDetailDTO.address1,
            address2 = breweryDetailDTO.address2,
            address3 = breweryDetailDTO.address3,
            city = breweryDetailDTO.city,
            stateProvince = breweryDetailDTO.stateProvince,
            postalCode = breweryDetailDTO.postalCode,
            country = breweryDetailDTO.country,
            longitude = breweryDetailDTO.longitude,
            latitude = breweryDetailDTO.latitude,
            phone = breweryDetailDTO.phone,
            websiteUrl = breweryDetailDTO.websiteUrl,
            state = breweryDetailDTO.state,
            street = breweryDetailDTO.street
        )
    }
}
