package com.henrique.datasource.datasource.brewerylist.data.datasource

import com.henrique.datasource.datasource.brewery.data.mappers.BreweryMapper
import com.henrique.datasource.datasource.brewerylist.data.service.BreweryListService
import com.henrique.datasource.datasource.brewerylist.domain.interfaces.datasource.BreweryListDataSource
import com.henrique.datasource.util.StubFactory
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before

@ExperimentalCoroutinesApi
class BreweryListDataSourceImplTest {
    private lateinit var breweryListDataSource: BreweryListDataSource
    private val breweryListService: BreweryListService = mockk(relaxed = true)
    private val breweryMapper: BreweryMapper = mockk(relaxed = true)

    @Before
    fun setup() {
        breweryListDataSource = getBreweryListDataSource()
    }

    @Test
    fun `GIVEN BreweryListDataSource WHEN getBreweryList() is called SHOULD return a list of Brewery`() {
        runBlocking {
            coEvery { breweryListService.getBreweryList("") } answers { StubFactory().breweryDTOList() }
            every { breweryMapper.toList(StubFactory().breweryDTOList()) } answers { StubFactory().breweryList() }

            val breweryList = breweryListDataSource.getBreweryList()
            assert(breweryList == StubFactory().breweryList())

            coVerify(exactly = 1) { breweryListService.getBreweryList("") }
            verify(exactly = 1) { breweryMapper.toList(StubFactory().breweryDTOList()) }
        }
    }

    private fun getBreweryListDataSource() = BreweryListDataSourceImpl(
        breweryListService, breweryMapper
    )
}