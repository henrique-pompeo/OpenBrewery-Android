package com.henrique.openbrewery.domain.brewerylist.mappers

import android.location.Location
import android.location.LocationManager
import com.henrique.openbrewery.domain.brewery.model.Brewery
import com.henrique.openbrewery.domain.brewerylist.model.BreweryAddress
import com.henrique.openbrewery.domain.brewerylist.model.BreweryListItem

class BreweryListItemMapper {
    private fun toItem(brewery: Brewery) : BreweryListItem {
        return BreweryListItem(
            id = brewery.id,
            name = brewery.name,
            address = BreweryAddress(
                street = brewery.street,
                address2 = brewery.address2,
                address3 = brewery.address3,
                city = brewery.city,
                state = brewery.state,
                countyProvince = brewery.countyProvince,
                postalCode = brewery.postalCode,
                country = brewery.country
            ),
            phone = brewery.phone,
            type = brewery.breweryType,
            distance = distance(
                latitude = brewery.latitude,
                longitude = brewery.longitude
            )
        )
    }

    private fun distance(latitude: String?, longitude: String?) : String {

        val location = Location(LocationManager.GPS_PROVIDER)
        val results = FloatArray(3)

        Location.distanceBetween(
            latitude?.toDouble() ?: 0.0,
            longitude?.toDouble() ?: 0.0,
            location.latitude,
            location.longitude,
            results
            )

        return String.format("%.2f", results[0].div(1000))
    }

    fun toList(breweryList: List<Brewery>) : List<BreweryListItem> {
        return breweryList.map(::toItem)
    }
}
