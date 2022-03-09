package com.henrique.brewerydetail.data.datasource

import com.henrique.brewerydetail.data.service.BreweryDetailService
import com.henrique.brewerydetail.BreweryDetailTest
import com.henrique.brewerydetail.data.datasource.remote.BreweryDetailDataSource
import com.henrique.brewerydetail.data.datasource.remote.BreweryDetailDataSourceImpl
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.koin.core.component.KoinApiExtension

@ExperimentalCoroutinesApi
@KoinApiExtension
class BreweryDetailDataSourceImplTest : BreweryDetailTest() {

    private lateinit var breweryDetailDataSource: BreweryDetailDataSource

    private val breweryDetailService = mockk<BreweryDetailService>()

    @Test
    fun `GIVEN BreweryDetailDataSource WHEN getBreweryById() is called SHOULD return a Brewery object`() =
        runBlocking {
            breweryDetailDataSource = BreweryDetailDataSourceImpl(breweryDetailService)

            coEvery { breweryDetailService.getBreweryById("id") } returns breweryResponse

            val response = breweryDetailDataSource.getBreweryById("id")

            Assert.assertEquals(response, brewery)

            coVerify(exactly = 1) { breweryDetailService.getBreweryById("id") }

            confirmVerified(breweryDetailService)
        }

}