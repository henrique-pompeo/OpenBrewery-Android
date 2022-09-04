package com.henrique.datasource.brewerylist.domain.mapper

import com.henrique.datasource.brewerylist.domain.model.Brewery
import com.henrique.datasource.brewerylist.domain.model.BreweryDTO

class BreweryMapper {
    fun toDomain(breweryListDTO: List<BreweryDTO>) : List<Brewery> {
        return breweryListDTO.map { breweryDTO ->
            Brewery(
                id = breweryDTO.id,
                name = breweryDTO.name,
                breweryType = breweryDTO.breweryType,
                street = breweryDTO.street,
                address2 = breweryDTO.address2,
                address3 = breweryDTO.address3,
                city = breweryDTO.city,
                state = breweryDTO.state,
                countyProvince = breweryDTO.countyProvince,
                postalCode = breweryDTO.postalCode,
                country = breweryDTO.country,
                longitude = breweryDTO.longitude,
                latitude = breweryDTO.latitude,
                phone = breweryDTO.phone,
                websiteUrl = breweryDTO.websiteUrl,
                updatedAt = breweryDTO.updatedAt,
                createdAt = breweryDTO.createdAt
            )
        }
    }
}