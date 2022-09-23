package com.henrique.datasource.datasource.brewerylist.data.mappers

import com.henrique.datasource.dataprovider.providers.database.openbrewery.entity.BreweryEntity
import com.henrique.datasource.datasource.brewerylist.domain.model.Brewery
import com.henrique.datasource.datasource.brewerylist.domain.model.BreweryDTO

class BreweryMapper {
    fun toDomain(breweryDTO: BreweryDTO) : Brewery {
        return Brewery(
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

    fun toDomainEntity(breweryEntity: BreweryEntity) : Brewery {
        return Brewery(
            id = breweryEntity.id,
            name = breweryEntity.name,
            breweryType = breweryEntity.breweryType,
            street = breweryEntity.street,
            address2 = breweryEntity.address2,
            address3 = breweryEntity.address3,
            city = breweryEntity.city,
            state = breweryEntity.state,
            countyProvince = breweryEntity.countyProvince,
            postalCode = breweryEntity.postalCode,
            country = breweryEntity.country,
            longitude = breweryEntity.longitude,
            latitude = breweryEntity.latitude,
            phone = breweryEntity.phone,
            websiteUrl = breweryEntity.websiteUrl,
            updatedAt = breweryEntity.updatedAt,
            createdAt = breweryEntity.createdAt
        )
    }

    fun toDatabase(brewery: Brewery) : BreweryEntity {
        return BreweryEntity(
            id = brewery.id,
            name = brewery.name,
            breweryType = brewery.breweryType,
            street = brewery.street,
            address2 = brewery.address2,
            address3 = brewery.address3,
            city = brewery.city,
            state = brewery.state,
            countyProvince = brewery.countyProvince,
            postalCode = brewery.postalCode,
            country = brewery.country,
            longitude = brewery.longitude,
            latitude = brewery.latitude,
            phone = brewery.phone,
            websiteUrl = brewery.websiteUrl,
            updatedAt = brewery.updatedAt,
            createdAt = brewery.createdAt
        )
    }

    fun toList(breweryListDTO: List<BreweryDTO>) : List<Brewery> {
        return breweryListDTO.map(::toDomain)
    }

    fun toListEntity(breweryListEntity: List<BreweryEntity>) : List<Brewery> {
        return breweryListEntity.map(::toDomainEntity)
    }

    fun toListDatabase(breweryList: List<Brewery>) : List<BreweryEntity> {
        return breweryList.map(::toDatabase)
    }
}