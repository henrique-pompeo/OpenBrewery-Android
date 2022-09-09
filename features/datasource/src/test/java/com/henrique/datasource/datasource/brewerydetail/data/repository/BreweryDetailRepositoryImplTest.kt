package com.henrique.datasource.datasource.brewerydetail.data.repository

import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDataSource
import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDatabaseProvider
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetailStatus
import io.mockk.coEvery
import io.mockk.coVerify
import org.koin.core.component.KoinApiExtension
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import java.io.IOException
import java.lang.Exception

@ExperimentalCoroutinesApi
@KoinApiExtension
class BreweryDetailRepositoryImplTest : com.henrique.datasource.base.UnitTest() {

    private val breweryDetailDataSource = mockk<BreweryDetailDataSource>()
    private val breweryDetailLocalDataSource = mockk<BreweryDetailDatabaseProvider>()
    private val breweryDetailRepository = BreweryDetailRepositoryImpl(
        breweryDetailDataSource, breweryDetailLocalDataSource
    )

    @Test
    fun `GIVEN BreweryDetailRepository WHEN getBreweryById() is called AND get a Brewery object SHOULD return success`() =
        runBlocking {

            coEvery { breweryDetailDataSource.getBreweryDetails("id") } returns breweryResponse

            val response = breweryDetailRepository.getBreweryDetails("id")
            Assert.assertEquals(response, BreweryDetailStatus.Success(brewery))

            coVerify(exactly = 1) { breweryDetailDataSource.getBreweryDetails("id") }
        }

    @Test
    fun `GIVEN BreweryDetailRepository WHEN getBreweryById() is called AND get a null Brewery object SHOULD return error`() =
        runBlocking {

            coEvery { breweryDetailDataSource.getBreweryDetails("null") } returns null

            val response = breweryDetailRepository.getBreweryDetails("null")
            Assert.assertEquals(response, BreweryDetailStatus.Error(errorMessage))

            coVerify(exactly = 1) { breweryDetailDataSource.getBreweryDetails("null") }
        }

    @Test
    fun `GIVEN BreweryDetailRepository WHEN getBreweryById() is called AND throws exception related to services SHOULD return success getting object from local database`() =
        runBlocking {

            coEvery { breweryDetailDataSource.getBreweryDetails("id") } throws IOException()
            coEvery { breweryDetailLocalDataSource.getBreweryDetails("id") } returns breweryEntity

            val response = breweryDetailRepository.getBreweryDetails("id")
            Assert.assertEquals(response, BreweryDetailStatus.Success(brewery))

            coVerify(exactly = 1) { breweryDetailDataSource.getBreweryDetails("id") }
            coVerify(exactly = 1) { breweryDetailLocalDataSource.getBreweryDetails("id") }
        }

    @Test
    fun `GIVEN BreweryDetailRepository WHEN getBreweryById() is called AND throws exception not related to services SHOULD return error`() =
        runBlocking {

            val exception = Exception()

            coEvery { breweryDetailDataSource.getBreweryDetails("id") } throws exception

            val response = breweryDetailRepository.getBreweryDetails("id")
            Assert.assertEquals(response, BreweryDetailStatus.Error(exception.message))

            coVerify(exactly = 1) { breweryDetailDataSource.getBreweryDetails("id") }
        }

    @Test
    fun `GIVEN BreweryDetailRepository WHEN trying to call getBreweryById() from both datasources AND they throws exception SHOULD return error`() =
        runBlocking {

            val exception = Exception()

            coEvery { breweryDetailDataSource.getBreweryDetails("id") } throws IOException()
            coEvery { breweryDetailLocalDataSource.getBreweryDetails("id") } throws exception

            val response = breweryDetailRepository.getBreweryDetails("id")
            Assert.assertEquals(response, BreweryDetailStatus.Error(exception.message))

            coVerify(exactly = 1) { breweryDetailDataSource.getBreweryDetails("id") }
            coVerify(exactly = 1) { breweryDetailLocalDataSource.getBreweryDetails("id") }
        }

    companion object {
        const val errorMessage = "No data available"
    }
}