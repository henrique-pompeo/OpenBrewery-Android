package com.henrique.openbrewery.domain.brewerydetail.mappers

import com.henrique.openbrewery.brewerydetail.domain.mappers.BreweryDetailItemMapper
import com.henrique.openbrewery.util.StubFactory
import org.junit.Test

class BreweryDetailItemMapperTest {
    private val mapper = BreweryDetailItemMapper()

    @Test
    fun `Ensure toItem() maps fields correctly WHEN provided`() {
        val breweryDetailMapped = mapper.toItem(StubFactory().breweryDetail())
        val breweryListExpected = StubFactory().breweryDetailItem()

        assert(breweryDetailMapped == breweryListExpected)
    }
}