package com.henrique.datasource.datasource.brewery.data.mappers

import com.henrique.datasource.util.StubFactory
import org.junit.Test

class BreweryMapperTest {
    private val mapper = BreweryMapper()

    @Test
    fun `Ensure toList() maps fields correctly WHEN provided`() {
        val breweryListMapped = mapper.toList(StubFactory().breweryDTOList())
        val breweryListExpected = StubFactory().breweryList()

        assert(breweryListMapped  == breweryListExpected)
    }

    @Test
    fun `Ensure toListEntity() maps fields correctly WHEN provided`() {
        val breweryListMapped = mapper.toListEntity(StubFactory().breweryEntityList())
        val breweryListExpected = StubFactory().breweryList()

        assert(breweryListMapped  == breweryListExpected)
    }

    @Test
    fun `Ensure toListDatabase() maps fields correctly WHEN provided`() {
        val breweryListMapped = mapper.toListDatabase(StubFactory().breweryList())
        val breweryListExpected = StubFactory().breweryEntityList()

        assert(breweryListMapped  == breweryListExpected)
    }
}
