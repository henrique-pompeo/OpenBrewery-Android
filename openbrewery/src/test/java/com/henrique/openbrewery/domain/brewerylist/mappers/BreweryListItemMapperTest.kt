package com.henrique.openbrewery.domain.brewerylist.mappers

import com.henrique.openbrewery.util.StubFactory
import org.junit.Test

class BreweryListItemMapperTest {
    private val mapper = BreweryListItemMapper()

    @Test
    fun `Ensure toItem() maps fields correctly WHEN provided`() {
        val breweryDetailMapped = mapper.toList(StubFactory().breweryList())
        val breweryListExpected = StubFactory().breweryListItemList()

        assert(breweryDetailMapped == breweryListExpected)
    }
}