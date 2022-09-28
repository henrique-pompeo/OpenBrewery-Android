package com.henrique.datasource.util

import com.henrique.datasource.dataprovider.providers.database.openbrewery.entity.BreweryEntity
import com.henrique.datasource.datasource.brewery.data.dto.BreweryDTO
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail
import com.henrique.datasource.datasource.brewery.domain.model.Brewery
import com.henrique.datasource.datasource.brewerydetail.data.dto.BreweryDetailDTO

class StubFactory {

    private fun breweryDTO() = BreweryDTO(
        id = TestConstants.id,
        name = TestConstants.name,
        breweryType = TestConstants.breweryType,
        street = TestConstants.street,
        address2 = TestConstants.address2,
        address3 = TestConstants.address3,
        city = TestConstants.city,
        state = TestConstants.state,
        countyProvince = TestConstants.countyProvince,
        postalCode = TestConstants.postalCode,
        country = TestConstants.country,
        longitude = TestConstants.longitude,
        latitude = TestConstants.latitude,
        phone = TestConstants.phone,
        websiteUrl = TestConstants.websiteUrl,
        updatedAt = TestConstants.updatedAt,
        createdAt = TestConstants.createdAt
    )

    fun breweryDTOList() = listOf(
        breweryDTO(),
        breweryDTO().copy(id = "10-barrel-brewing-co-bend-1"),
        breweryDTO().copy(id = "10-barrel-brewing-co-bend-2")
    )

    private fun brewery() = Brewery(
        id = TestConstants.id,
        name = TestConstants.name,
        breweryType = TestConstants.breweryType,
        street = TestConstants.street,
        address2 = TestConstants.address2,
        address3 = TestConstants.address3,
        city = TestConstants.city,
        state = TestConstants.state,
        countyProvince = TestConstants.countyProvince,
        postalCode = TestConstants.postalCode,
        country = TestConstants.country,
        longitude = TestConstants.longitude,
        latitude = TestConstants.latitude,
        phone = TestConstants.phone,
        websiteUrl = TestConstants.websiteUrl,
        updatedAt = TestConstants.updatedAt,
        createdAt = TestConstants.createdAt
    )

    fun breweryList() = listOf(
        brewery(),
        brewery().copy(id = "10-barrel-brewing-co-bend-1"),
        brewery().copy(id = "10-barrel-brewing-co-bend-2")
    )

    fun breweryDetailDTO() = BreweryDetailDTO(
        id = TestConstants.id,
        name = TestConstants.name,
        breweryType = TestConstants.breweryType,
        street = TestConstants.street,
        address2 = TestConstants.address2,
        address3 = TestConstants.address3,
        city = TestConstants.city,
        state = TestConstants.state,
        countyProvince = TestConstants.countyProvince,
        postalCode = TestConstants.postalCode,
        country = TestConstants.country,
        longitude = TestConstants.longitude,
        latitude = TestConstants.latitude,
        phone = TestConstants.phone,
        websiteUrl = TestConstants.websiteUrl,
        updatedAt = TestConstants.updatedAt,
        createdAt = TestConstants.createdAt
    )

    fun breweryDetail() = BreweryDetail(
        id = TestConstants.id,
        name = TestConstants.name,
        breweryType = TestConstants.breweryType,
        street = TestConstants.street,
        address2 = TestConstants.address2,
        address3 = TestConstants.address3,
        city = TestConstants.city,
        state = TestConstants.state,
        countyProvince = TestConstants.countyProvince,
        postalCode = TestConstants.postalCode,
        country = TestConstants.country,
        longitude = TestConstants.longitude,
        latitude = TestConstants.latitude,
        phone = TestConstants.phone,
        websiteUrl = TestConstants.websiteUrl,
        updatedAt = TestConstants.updatedAt,
        createdAt = TestConstants.createdAt
    )

    fun breweryEntity() = BreweryEntity(
        id = TestConstants.id,
        name = TestConstants.name,
        breweryType = TestConstants.breweryType,
        street = TestConstants.street,
        address2 = TestConstants.address2,
        address3 = TestConstants.address3,
        city = TestConstants.city,
        state = TestConstants.state,
        countyProvince = TestConstants.countyProvince,
        postalCode = TestConstants.postalCode,
        country = TestConstants.country,
        longitude = TestConstants.longitude,
        latitude = TestConstants.latitude,
        phone = TestConstants.phone,
        websiteUrl = TestConstants.websiteUrl,
        updatedAt = TestConstants.updatedAt,
        createdAt = TestConstants.createdAt
    )

    fun breweryEntityList() = listOf(
        breweryEntity(),
        breweryEntity().copy(id = "10-barrel-brewing-co-bend-1"),
        breweryEntity().copy(id = "10-barrel-brewing-co-bend-2")
    )
}
