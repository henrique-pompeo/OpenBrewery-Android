package com.henrique.openbrewery.domain.brewerylist.mappers

import com.henrique.openbrewery.domain.brewery.model.Brewery
import com.henrique.openbrewery.domain.brewerylist.model.BreweryListItem

class BreweryListItemMapper {
    private fun toItem(brewery: Brewery) : BreweryListItem {
        return BreweryListItem(
            id = brewery.id,
            name = brewery.name,
            address = brewery.country,
            phone = brewery.phone,
            type = brewery.breweryType
        )
    }

    fun toList(breweryList: List<Brewery>) : List<BreweryListItem> {
        return breweryList.map(::toItem)
    }
}
