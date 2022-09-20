package com.henrique.openbrewery.domain.brewerylist.mappers

import com.henrique.datasource.datasource.brewerylist.domain.model.Brewery as BreweryDatasource
import com.henrique.openbrewery.domain.brewerylist.model.BreweryListItem

class BreweryListItemMapper {
    fun toItem(
        name: String,
        address: String,
        phone: String
    ) : BreweryListItem {
        return BreweryListItem(
            name = name,
            address = address,
            phone = phone
        )
    }

    fun toList(breweryListDatasource: List<BreweryDatasource>) : List<BreweryListItem> {
        return breweryListDatasource.map {
            toItem(
                name = it.name.orEmpty(),
                address = it.country.orEmpty(),
                phone = it.phone.orEmpty()
            )
        }
    }
}
