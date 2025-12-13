package com.henrique.datasource.datasource.brewerydetail.data.mappers

import com.henrique.datasource.dataprovider.providers.database.openbrewery.entity.BreweryEntity
import com.henrique.datasource.datasource.brewerydetail.data.dto.BreweryDetailDTO
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail

class BreweryDetailMapper {
    fun toDomain(breweryDetailDTO: BreweryDetailDTO): BreweryDetail {
        return BreweryDetail(
            id = breweryDetailDTO.id,
            name = breweryDetailDTO.name,
            breweryType = breweryDetailDTO.breweryType,
            street = breweryDetailDTO.street,
            address2 = breweryDetailDTO.address2,
            address3 = breweryDetailDTO.address3,
            city = breweryDetailDTO.city,
            state = breweryDetailDTO.state,
            countyProvince = breweryDetailDTO.countyProvince,
            postalCode = breweryDetailDTO.postalCode,
            country = breweryDetailDTO.country,
            longitude = breweryDetailDTO.longitude,
            latitude = breweryDetailDTO.latitude,
            phone = breweryDetailDTO.phone,
            websiteUrl = breweryDetailDTO.websiteUrl,
            updatedAt = breweryDetailDTO.updatedAt,
            createdAt = breweryDetailDTO.createdAt
        )
    }

    fun toDomainEntity(breweryEntity: BreweryEntity): BreweryDetail {
        return BreweryDetail(
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
}
