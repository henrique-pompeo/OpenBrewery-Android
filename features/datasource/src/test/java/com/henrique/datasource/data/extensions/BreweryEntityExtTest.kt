package com.henrique.datasource.data.extensions

import com.henrique.datasource.UnitTest
import org.junit.Assert
import org.junit.Test

class BreweryEntityExtTest : UnitTest() {

    @Test
    fun `GIVEN BreweryEntity WHEN model() is called SHOULD return its Brewery object`() {
        Assert.assertEquals(breweryEntity.model(), brewery)
    }

}