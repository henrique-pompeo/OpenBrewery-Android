package com.henrique.openbrewery.domain.brewery.mappers

import com.henrique.openbrewery.util.StubFactory
import org.junit.Test

class BreweryMapperTest {
    private val mapper = BreweryMapper()

    @Test
    fun `Ensure toList() maps fields correctly WHEN provided`() {
        val breweryListMapped = mapper.toList(StubFactory().datasourceBreweryList())
        val breweryListExpected = StubFactory().breweryList()

        assert(breweryListMapped  == breweryListExpected)
    }
}