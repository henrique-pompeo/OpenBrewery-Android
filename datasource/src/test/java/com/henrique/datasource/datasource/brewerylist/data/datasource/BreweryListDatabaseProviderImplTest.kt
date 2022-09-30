package com.henrique.datasource.datasource.brewerylist.data.datasource

import com.henrique.datasource.dataprovider.providers.database.openbrewery.dao.BreweryDao
import com.henrique.datasource.datasource.brewery.data.mappers.BreweryMapper
import com.henrique.datasource.datasource.brewerylist.domain.interfaces.datasource.BreweryListDatabaseProvider
import com.henrique.datasource.util.StubFactory
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class BreweryListDatabaseProviderImplTest {
    private lateinit var breweryListDatabaseProvider: BreweryListDatabaseProvider
    private val breweryDao: BreweryDao = mockk(relaxed = true)
    private val breweryMapper: BreweryMapper = mockk(relaxed = true)

    @Before
    fun setup() {
        breweryListDatabaseProvider = getBreweryListDatabaseProvider()
    }

    @Test
    fun `GIVEN BreweryListDatabaseProvider WHEN getBreweryList() is called SHOULD return a list of Brewery`() {
        runBlocking {
            coEvery { breweryDao.getBreweryList() } answers { StubFactory().breweryEntityList() }
            every { breweryMapper.toListEntity(StubFactory().breweryEntityList()) } answers { StubFactory().breweryList() }

            val breweryList = breweryListDatabaseProvider.getBreweryList()
            assert(breweryList == StubFactory().breweryList())

            coVerify(exactly = 1) { breweryDao.getBreweryList() }
            verify(exactly = 1) { breweryMapper.toListEntity(StubFactory().breweryEntityList()) }
        }
    }

    @Test
    fun `GIVEN BreweryListDatabaseProvider WHEN insertBreweryList() is called SHOULD insert a list of Brewery`() {
        runBlocking {
            every { breweryMapper.toListDatabase(StubFactory().breweryList()) } answers { StubFactory().breweryEntityList() }

            breweryListDatabaseProvider.insertBreweryList(StubFactory().breweryList())

            coVerify(exactly = 1) { breweryDao.insertBreweryList(StubFactory().breweryEntityList()) }
            verify(exactly = 1) { breweryMapper.toListDatabase(StubFactory().breweryList()) }
        }
    }

    private fun getBreweryListDatabaseProvider() = BreweryListDatabaseProviderImpl(
        breweryDao, breweryMapper
    )
}