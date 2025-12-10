package com.henrique.openbrewery.util

import com.henrique.datasource.datasource.brewerydetail.domain.model
.BreweryDetail as DatasourceBreweryDetail
import com.henrique.openbrewery.domain.brewery.model.Brewery
import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetail
import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetailItem
import com.henrique.openbrewery.brewerylist.domain.model.BreweryListItem
import com.henrique.datasource.datasource.brewery.domain.model.Brewery as DatasourceBrewery
import com.henrique.openbrewery.brewerylist.domain.model.BreweryAddress

class StubFactory {

    private fun datasourceBrewery() = DatasourceBrewery(
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

    fun datasourceBreweryList() = listOf(
        datasourceBrewery(),
        datasourceBrewery().copy(id = "10-barrel-brewing-co-bend-1"),
        datasourceBrewery().copy(id = "10-barrel-brewing-co-bend-2")
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

    fun datasourceBreweryDetail() = DatasourceBreweryDetail(
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

    fun breweryDetailItem() = BreweryDetailItem(
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

    private fun breweryAddress() = BreweryAddress(
        street = TestConstants.street,
        address2 = TestConstants.address2,
        address3 = TestConstants.address3,
        city = TestConstants.city,
        state = TestConstants.state,
        countyProvince = TestConstants.countyProvince,
        postalCode = TestConstants.postalCode,
        country = TestConstants.country
    )

    private fun breweryListItem() = BreweryListItem(
        id = TestConstants.id,
        name = TestConstants.name,
        address = breweryAddress(),
        phone = TestConstants.phone,
        type = TestConstants.breweryType
    )

    fun breweryListItemList() = listOf(
        breweryListItem(),
        breweryListItem().copy(id = "10-barrel-brewing-co-bend-1"),
        breweryListItem().copy(id = "10-barrel-brewing-co-bend-2")
    )
}