package com.henrique.datasource.datasource.brewerydetail.data.mappers

import com.henrique.datasource.util.StubFactory
import org.junit.Test

class BreweryDetailMapperTest {
    private val mapper = BreweryDetailMapper()

    @Test
    fun `Ensure toDomain() maps fields correctly WHEN provided`() {
        val breweryDetailMapped = mapper.toDomain(StubFactory().breweryDetailDTO())
        val breweryDetailExpected = StubFactory().breweryDetail()

        assert(breweryDetailMapped  == breweryDetailExpected)
    }

    @Test
    fun `Ensure toDomainEntity() maps fields correctly WHEN provided`() {
        val breweryDetailMapped = mapper.toDomainEntity(StubFactory().breweryEntity())
        val breweryDetailExpected = StubFactory().breweryDetail()

        assert(breweryDetailMapped  == breweryDetailExpected)
    }
}
