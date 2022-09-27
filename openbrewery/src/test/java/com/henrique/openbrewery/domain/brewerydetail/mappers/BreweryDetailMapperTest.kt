package com.henrique.openbrewery.domain.brewerydetail.mappers

import com.henrique.openbrewery.util.StubFactory
import org.junit.Test

class BreweryDetailMapperTest {
    private val mapper = BreweryDetailMapper()

    @Test
    fun `Ensure toDomain() maps fields correctly WHEN provided`() {
        val breweryDetailMapped = mapper.toDomain(StubFactory().datasourceBreweryDetail())
        val breweryListExpected = StubFactory().breweryDetail()

        assert(breweryDetailMapped == breweryListExpected)
    }
}