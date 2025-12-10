package com.henrique.datasource.datasource.brewerylist.data.repository

import com.henrique.datasource.datasource.brewerylist.domain.interfaces.datasource.BreweryListDataSource
import com.henrique.datasource.datasource.brewerylist.domain.interfaces.datasource.BreweryListDatabaseProvider
import com.henrique.datasource.datasource.brewerylist.domain.interfaces.repository.BreweryListRepository
import com.henrique.datasource.util.StubFactory
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class BreweryListRepositoryImplTest {
    private val breweryListRepository: BreweryListRepository = getBreweryListRepository()
    private val breweryListDataSource: BreweryListDataSource = mockk(relaxed = true)
    private val breweryListDatabaseProvider: BreweryListDatabaseProvider = mockk(relaxed = true)

    @Test
    fun `GIVEN BreweryListRepository WHEN getBreweryList() is called SHOULD return a list of Brewery`() {
        runBlocking {
            coEvery { breweryListDataSource.getBreweryList() } answers { StubFactory().breweryList() }

            val breweryList = breweryListRepository.getBreweryList()
            assert(breweryList == StubFactory().breweryList())

            coVerify(exactly = 1) { breweryListDataSource.getBreweryList() }
        }
    }

    @Test
    fun `GIVEN BreweryListRepository WHEN getDatabaseBreweryList() is called SHOULD return a list of Brewery`() {
        runBlocking {
            coEvery { breweryListDatabaseProvider.getBreweryList() } answers { StubFactory().breweryList() }

            val breweryList = breweryListRepository.getDatabaseBreweryList()
            assert(breweryList == StubFactory().breweryList())

            coVerify(exactly = 1) { breweryListDatabaseProvider.getBreweryList() }
        }
    }

    @Test
    fun `GIVEN BreweryListRepository WHEN insertBreweryList() is called SHOULD insert a list of Brewery`() {
        runBlocking {
            breweryListRepository.insertBreweryList(StubFactory().breweryList())
            coVerify(exactly = 1) { breweryListDatabaseProvider.insertBreweryList(StubFactory().breweryList()) }
        }
    }

    private fun getBreweryListRepository() = BreweryListRepositoryImpl(
        breweryListDataSource, breweryListDatabaseProvider
    )
}
