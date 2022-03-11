package com.henrique.shared.data.database.entities

import com.henrique.shared.UnitTest
import org.junit.Assert
import org.junit.Test
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryEntityTest : UnitTest() {

    @Test
    fun `should initialize BreweryEntity`() {
        Assert.assertEquals(breweryEntity.id, "id")
        Assert.assertEquals(breweryEntity.name, "name")
        Assert.assertEquals(breweryEntity.breweryType, "breweryType")
        Assert.assertEquals(breweryEntity.street, "street")
        Assert.assertEquals(breweryEntity.address2, "address2")
        Assert.assertEquals(breweryEntity.address3, "address3")
        Assert.assertEquals(breweryEntity.city, "city")
        Assert.assertEquals(breweryEntity.state, "state")
        Assert.assertEquals(breweryEntity.countyProvince, "countyProvince")
        Assert.assertEquals(breweryEntity.postalCode, "postalCode")
        Assert.assertEquals(breweryEntity.country, "country")
        Assert.assertEquals(breweryEntity.longitude, "longitude")
        Assert.assertEquals(breweryEntity.latitude, "latitude")
        Assert.assertEquals(breweryEntity.phone, "phone")
        Assert.assertEquals(breweryEntity.websiteUrl, "websiteUrl")
        Assert.assertEquals(breweryEntity.updatedAt, "2021-10-23T02:24:55.243Z")
        Assert.assertEquals(breweryEntity.createdAt, "2021-10-23T02:24:55.243Z")
    }
}