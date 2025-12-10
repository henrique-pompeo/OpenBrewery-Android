package com.henrique.datasource.datasource.brewerydetail.data.datasource

import com.henrique.datasource.datasource.brewerydetail.data.mappers.BreweryDetailMapper
import com.henrique.datasource.datasource.brewerydetail.data.service.BreweryDetailService
import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDataSource
import com.henrique.datasource.util.StubFactory
import com.henrique.datasource.util.TestConstants
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class BreweryDetailDataSourceImplTest {
    private val breweryDetailDataSource: BreweryDetailDataSource = getBreweryDetailLocalDataSource()
    private val breweryDetailService: BreweryDetailService = mockk(relaxed = true)
    private val breweryDetailMapper: BreweryDetailMapper = mockk(relaxed = true)

    @Test
    fun `GIVEN BreweryDetailDataSource WHEN getBreweryDetails() is called SHOULD return a BreweryDTO`() {
        runBlocking {
            coEvery { breweryDetailService.getBreweryDetails(TestConstants.id) }  answers { StubFactory().breweryDetailDTO() }
            every { breweryDetailMapper.toDomain(StubFactory().breweryDetailDTO()) } answers { StubFactory().breweryDetail() }

            val breweryDetail = breweryDetailDataSource.getBreweryDetails(TestConstants.id)
            assert(breweryDetail == StubFactory().breweryDetail())

            coVerify(exactly = 1) { breweryDetailService.getBreweryDetails(TestConstants.id) }
        }
    }


    private fun getBreweryDetailLocalDataSource() = BreweryDetailDataSourceImpl(
        breweryDetailService, breweryDetailMapper
    )
}
