package com.henrique.datasource.data.remote.response

import com.henrique.datasource.UnitTest
import org.junit.Assert
import org.junit.Test

class BreweryResponseTest : UnitTest() {

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
}