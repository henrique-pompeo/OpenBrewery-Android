package com.henrique.openbrewery.domain.brewerydetail.mappers

import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail as DatasourceBreweryDetail
import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetail

class BreweryDetailMapper {
    fun toDomain(datasourceBrewery: DatasourceBreweryDetail) : BreweryDetail {
        return BreweryDetail(
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
}
