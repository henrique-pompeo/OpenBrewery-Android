package com.henrique.brewerydetail.data.repository

import com.henrique.brewerydetail.data.datasource.BreweryDetailDataSource
import com.henrique.brewerydetail.BreweryDetailTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import org.koin.core.component.KoinApiExtension
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

@KoinApiExtension
class BreweryDetailRepositoryImplTest : BreweryDetailTest() {

    private lateinit var breweryDetailRepository: BreweryDetailRepository

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