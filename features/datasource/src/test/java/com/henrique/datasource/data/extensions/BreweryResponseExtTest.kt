package com.henrique.datasource.data.extensions

import com.henrique.datasource.UnitTest
import org.junit.Assert
import org.junit.Test

class BreweryResponseExtTest : UnitTest() {

    @Test
    fun `GIVEN BreweryResponse WHEN model() is called SHOULD return its Brewery object`() {
        Assert.assertEquals(breweryResponse.model(), brewery)
    }

    @Test
    fun `GIVEN BreweryResponse WHEN toEntity() is called SHOULD return its BreweryEntity object`() {
        Assert.assertEquals(breweryResponse.toEntity().model(), breweryEntity.model())
    }

}