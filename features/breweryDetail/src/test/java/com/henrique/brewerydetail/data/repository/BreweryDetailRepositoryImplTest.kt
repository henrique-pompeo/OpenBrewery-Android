package com.henrique.brewerydetail.data.repository

import com.henrique.brewerydetail.data.datasource.remote.BreweryDetailDataSource
import com.henrique.brewerydetail.BreweryDetailTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import org.koin.core.component.KoinApiExtension
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
@KoinApiExtension
class BreweryDetailRepositoryImplTest : BreweryDetailTest() {

    private val breweryDetailDataSource = mockk<BreweryDetailDataSource>()

    @Test
    fun `GIVEN BreweryDetailRepository WHEN getBreweryById() is called SHOULD return a Brewery object`() =
        runBlocking {
            breweryDetailRepository = BreweryDetailRepositoryImpl(breweryDetailDataSource)

            coEvery { breweryDetailDataSource.getBreweryById("id") } returns brewery

            val response = breweryDetailRepository.getBreweryById("id")

            Assert.assertEquals(response, brewery)

            coVerify(exactly = 1) { breweryDetailDataSource.getBreweryById("id") }

            confirmVerified(breweryDetailDataSource)
        }
}