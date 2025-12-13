package com.henrique.openbrewery.brewerylist.data.mapper

import com.henrique.openbrewery.brewerylist.data.dto.BreweryListItemDTO
import com.henrique.openbrewery.brewerylist.domain.model.BreweryListItemModel

internal object BreweryListMapper {

    fun toList(breweryListDTO: List<BreweryListItemDTO>): List<BreweryListItemModel> {
        return breweryListDTO.map(::toDomain)
    }

    private fun toDomain(breweryDTO: BreweryListItemDTO): BreweryListItemModel {
        return BreweryListItemModel(
            id = breweryDTO.id,
            name = breweryDTO.name,
            breweryType = breweryDTO.breweryType,
            address1 = breweryDTO.address1,
            address2 = breweryDTO.address2,
            address3 = breweryDTO.address3,
            city = breweryDTO.city,
            stateProvince = breweryDTO.stateProvince,
            postalCode = breweryDTO.postalCode,
            country = breweryDTO.country,
            longitude = breweryDTO.longitude,
            latitude = breweryDTO.latitude,
            phone = breweryDTO.phone,
            websiteUrl = breweryDTO.websiteUrl,
            state = breweryDTO.state,
            street = breweryDTO.street
        )
    }
}
