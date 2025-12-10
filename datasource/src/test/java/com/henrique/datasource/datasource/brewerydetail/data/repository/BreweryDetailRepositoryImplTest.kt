package com.henrique.datasource.datasource.brewerydetail.data.repository

import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDataSource
import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDatabaseProvider
import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.repository.BreweryDetailRepository
import com.henrique.datasource.util.StubFactory
import com.henrique.datasource.util.TestConstants
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class BreweryDetailRepositoryImplTest {
    private val breweryDetailRepository: BreweryDetailRepository = getBreweryDetailRepository()
    private val breweryDetailDataSource: BreweryDetailDataSource = mockk(relaxed = true)
    private val breweryDetailDatabaseProvider: BreweryDetailDatabaseProvider = mockk(relaxed = true)

    @Test
    fun `GIVEN BreweryDetailRepository WHEN getBreweryDetails() is called SHOULD return a BreweryDetail`() {
        runBlocking {
            coEvery { breweryDetailDataSource.getBreweryDetails(TestConstants.id) } answers { StubFactory().breweryDetail() }

            val breweryDetail = breweryDetailRepository.getBreweryDetails(TestConstants.id)
            assert(breweryDetail == StubFactory().breweryDetail())

            coVerify(exactly = 1) { breweryDetailDataSource.getBreweryDetails(TestConstants.id) }
        }
    }

    @Test
    fun `GIVEN BreweryDetailRepository WHEN getDatabaseBreweryDetails() is called SHOULD return a BreweryDetail`() {
        runBlocking {
            coEvery { breweryDetailDatabaseProvider.getBreweryDetails(TestConstants.id) } answers {
                StubFactory().breweryDetail()
            }

            val breweryDetail = breweryDetailRepository.getDatabaseBreweryDetails(TestConstants.id)
            assert(breweryDetail == StubFactory().breweryDetail())

            coVerify(exactly = 1) { breweryDetailDatabaseProvider.getBreweryDetails(TestConstants.id) }
        }
    }

    private fun getBreweryDetailRepository() = BreweryDetailRepositoryImpl(
        breweryDetailDataSource, breweryDetailDatabaseProvider
    )
}
