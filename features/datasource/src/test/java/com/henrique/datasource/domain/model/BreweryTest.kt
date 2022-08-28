package com.henrique.datasource.domain.model

import org.junit.Assert
import org.junit.Test

class BreweryTest {

    @Test
    fun `should initialize Brewery`() {
        val brewery = Brewery(
            id = "id",
            name = "name",
            breweryType = "breweryType",
            street = "street",
            address2 = "address2",
            address3 = "address3",
            city = "city",
            state = "state",
            countyProvince = "countyProvince",
            postalCode = "postalCode",
            country = "country",
            longitude = "longitude",
            latitude = "latitude",
            phone = "phone",
            websiteUrl = "websiteUrl",
            updatedAt = "2021-10-23T02:24:55.243Z",
            createdAt = "2021-10-23T02:24:55.243Z"
        )

        Assert.assertEquals(brewery.id, "id")
        Assert.assertEquals(brewery.name, "name")
        Assert.assertEquals(brewery.breweryType, "breweryType")
        Assert.assertEquals(brewery.street, "street")
        Assert.assertEquals(brewery.address2, "address2")
        Assert.assertEquals(brewery.address3, "address3")
        Assert.assertEquals(brewery.city, "city")
        Assert.assertEquals(brewery.state, "state")
        Assert.assertEquals(brewery.countyProvince, "countyProvince")
        Assert.assertEquals(brewery.postalCode, "postalCode")
        Assert.assertEquals(brewery.country, "country")
        Assert.assertEquals(brewery.longitude, "longitude")
        Assert.assertEquals(brewery.latitude, "latitude")
        Assert.assertEquals(brewery.phone, "phone")
        Assert.assertEquals(brewery.websiteUrl, "websiteUrl")
        Assert.assertEquals(brewery.updatedAt, "2021-10-23T02:24:55.243Z")
        Assert.assertEquals(brewery.createdAt, "2021-10-23T02:24:55.243Z")
    }
}