package com.henrique.datasource.datasource.brewerydetail.data.datasource

import com.henrique.datasource.dataprovider.providers.database.openbrewery.dao.BreweryDao
import com.henrique.datasource.datasource.brewerydetail.data.mappers.BreweryDetailMapper
import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDatabaseProvider
import com.henrique.datasource.util.StubFactory
import com.henrique.datasource.util.TestConstants
import com.henrique.datasource.util.UnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class BreweryDetailDatabaseProviderImplTest : UnitTest() {
    private lateinit var breweryDetailLocalDataSource: BreweryDetailDatabaseProvider
    private val breweryDao: BreweryDao = mockk(relaxed = true)
    private val breweryDetailMapper: BreweryDetailMapper = mockk(relaxed = true)

    @Before
    fun setup() {
        breweryDetailLocalDataSource = getBreweryDetailLocalDataSource()
    }

    @Test
    fun `GIVEN BreweryDetailLocalDataSource WHEN getBreweryById() is called SHOULD return a BreweryEntity`() =
        runBlocking {
            coEvery { breweryDao.getBreweryDetails(TestConstants.id) }  answers { StubFactory().breweryEntity() }
            every { breweryDetailMapper.toDomainEntity(StubFactory().breweryEntity()) } answers { StubFactory().breweryDetail() }

            val breweryDetail = breweryDetailLocalDataSource.getBreweryDetails(TestConstants.id)
            assert(breweryDetail == StubFactory().breweryDetail())

            coVerify(exactly = 1) { breweryDao.getBreweryDetails(TestConstants.id) }
        }

    private fun getBreweryDetailLocalDataSource() = BreweryDetailDatabaseProviderImpl(
        breweryDao, breweryDetailMapper
    )
}
