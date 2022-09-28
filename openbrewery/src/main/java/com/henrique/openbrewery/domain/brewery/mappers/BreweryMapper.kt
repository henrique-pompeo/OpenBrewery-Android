package com.henrique.openbrewery.domain.brewery.mappers

import com.henrique.openbrewery.domain.brewery.model.Brewery
import com.henrique.datasource.datasource.brewery.domain.model.Brewery as DatasourceBrewery

class BreweryMapper {
    private fun toDomain(datasourceBrewery: DatasourceBrewery) : Brewery {
        return Brewery(
            id = datasourceBrewery.id,
            name = datasourceBrewery.name,
            breweryType = datasourceBrewery.breweryType,
            street = datasourceBrewery.street,
            address2 = datasourceBrewery.address2,
            address3 = datasourceBrewery.address3,
            city = datasourceBrewery.city,
            state = datasourceBrewery.state,
            countyProvince = datasourceBrewery.countyProvince,
            postalCode = datasourceBrewery.postalCode,
            country = datasourceBrewery.country,
            longitude = datasourceBrewery.longitude,
            latitude = datasourceBrewery.latitude,
            phone = datasourceBrewery.phone,
            websiteUrl = datasourceBrewery.websiteUrl,
            updatedAt = datasourceBrewery.updatedAt,
            createdAt = datasourceBrewery.createdAt
        )
    }

    fun toList(datasourceBreweryList: List<DatasourceBrewery>) : List<Brewery> {
        return datasourceBreweryList.map(::toDomain)
    }
}
