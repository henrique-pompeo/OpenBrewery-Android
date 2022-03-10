package com.henrique.shared.data.remote.response

import com.henrique.shared.data.extensions.model
import com.henrique.shared.domain.model.Brewery
import org.junit.Assert
import org.junit.Test

class BreweryResponseTest {

    @Test
    fun `should initialize BreweryResponse`() {
        Assert.assertEquals(breweryResponse.id, "id")
        Assert.assertEquals(breweryResponse.name, "name")
        Assert.assertEquals(breweryResponse.breweryType, "breweryType")
        Assert.assertEquals(breweryResponse.street, "street")
        Assert.assertEquals(breweryResponse.address2, "address2")
        Assert.assertEquals(breweryResponse.address3, "address3")
        Assert.assertEquals(breweryResponse.city, "city")
        Assert.assertEquals(breweryResponse.state, "state")
        Assert.assertEquals(breweryResponse.countyProvince, "countyProvince")
        Assert.assertEquals(breweryResponse.postalCode, "postalCode")
        Assert.assertEquals(breweryResponse.country, "country")
        Assert.assertEquals(breweryResponse.longitude, "longitude")
        Assert.assertEquals(breweryResponse.latitude, "latitude")
        Assert.assertEquals(breweryResponse.phone, "phone")
        Assert.assertEquals(breweryResponse.websiteUrl, "websiteUrl")
        Assert.assertEquals(breweryResponse.updatedAt, "2021-10-23T02:24:55.243Z")
        Assert.assertEquals(breweryResponse.createdAt, "2021-10-23T02:24:55.243Z")
    }

    @Test
    fun `GIVEN BreweryResponse WHEN model() is called SHOULD return its Brewery object`() {
        Assert.assertEquals(breweryResponse.model(), brewery)
    }

    private companion object {
        val breweryResponse = BreweryResponse(
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
    }
}