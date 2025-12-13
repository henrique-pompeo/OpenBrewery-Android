package com.henrique.openbrewery.brewerylist.domain.mappers

import com.henrique.openbrewery.brewerylist.domain.model.BreweryAddress
import com.henrique.openbrewery.brewerylist.domain.model.BreweryListItem
import com.henrique.openbrewery.brewerylist.domain.model.BreweryListItemModel

internal object BreweryListItemMapper {
    fun toItem(brewery: BreweryListItemModel): BreweryListItem {
        return BreweryListItem(
            id = brewery.id,
            name = brewery.name,
            address = BreweryAddress(
                address1 = brewery.address1,
                address2 = brewery.address2,
                address3 = brewery.address3,
                city = brewery.city,
                stateProvince = brewery.stateProvince,
                postalCode = brewery.postalCode,
                country = brewery.country,
                street = brewery.street,
            ),
            phone = brewery.phone,
            type = brewery.breweryType
        )
    }

    fun toList(breweryList: List<BreweryListItemModel>): List<BreweryListItem> {
        return breweryList.map(::toItem)
    }
}
