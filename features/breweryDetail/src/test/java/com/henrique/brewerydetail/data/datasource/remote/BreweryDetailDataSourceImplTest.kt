package com.henrique.brewerydetail.data.datasource.remote

import com.henrique.brewerydetail.data.service.BreweryDetailService
import com.henrique.brewerydetail.UnitTest
import com.henrique.shared.data.extensions.model
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
class BreweryDetailDataSourceImplTest : UnitTest() {

    private val breweryDetailService = mockk<BreweryDetailService>()
    private val breweryDetailDataSource = BreweryDetailDataSourceImpl(breweryDetailService)

    @Test
    fun `GIVEN BreweryDetailDataSource WHEN getBreweryById() is called SHOULD return a Brewery object`() =
        runBlocking {

            coEvery { breweryDetailService.getBreweryById("id") } returns breweryResponse

            val response = breweryDetailDataSource.getBreweryById("id")
            Assert.assertEquals(response?.model(), brewery)

            coVerify(exactly = 1) { breweryDetailService.getBreweryById("id") }
        }

}