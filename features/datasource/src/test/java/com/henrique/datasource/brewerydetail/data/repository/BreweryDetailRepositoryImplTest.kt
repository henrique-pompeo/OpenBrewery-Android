package com.henrique.datasource.brewerydetail.data.repository

import com.henrique.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDataSource
import com.henrique.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailLocalDataSource
import com.henrique.datasource.data.ResultStatus
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
    private val breweryDetailLocalDataSource = mockk<BreweryDetailLocalDataSource>()
    private val breweryDetailRepository = BreweryDetailRepositoryImpl(
        breweryDetailDataSource, breweryDetailLocalDataSource
    )

    @Test
    fun `GIVEN BreweryDetailRepository WHEN getBreweryById() is called AND get a Brewery object SHOULD return success`() =
        runBlocking {

            coEvery { breweryDetailDataSource.getBreweryById("id") } returns breweryResponse

            val response = breweryDetailRepository.getBreweryById("id")
            Assert.assertEquals(response, ResultStatus.Success(brewery))

            coVerify(exactly = 1) { breweryDetailDataSource.getBreweryById("id") }
        }

    @Test
    fun `GIVEN BreweryDetailRepository WHEN getBreweryById() is called AND get a null Brewery object SHOULD return error`() =
        runBlocking {

            coEvery { breweryDetailDataSource.getBreweryById("null") } returns null

            val response = breweryDetailRepository.getBreweryById("null")
            Assert.assertEquals(response, ResultStatus.Error(errorMessage))

            coVerify(exactly = 1) { breweryDetailDataSource.getBreweryById("null") }
        }

    @Test
    fun `GIVEN BreweryDetailRepository WHEN getBreweryById() is called AND throws exception related to services SHOULD return success getting object from local database`() =
        runBlocking {

            coEvery { breweryDetailDataSource.getBreweryById("id") } throws IOException()
            coEvery { breweryDetailLocalDataSource.getBreweryById("id") } returns breweryEntity

            val response = breweryDetailRepository.getBreweryById("id")
            Assert.assertEquals(response, ResultStatus.Success(brewery))

            coVerify(exactly = 1) { breweryDetailDataSource.getBreweryById("id") }
            coVerify(exactly = 1) { breweryDetailLocalDataSource.getBreweryById("id") }
        }

    @Test
    fun `GIVEN BreweryDetailRepository WHEN getBreweryById() is called AND throws exception not related to services SHOULD return error`() =
        runBlocking {

            val exception = Exception()

            coEvery { breweryDetailDataSource.getBreweryById("id") } throws exception

            val response = breweryDetailRepository.getBreweryById("id")
            Assert.assertEquals(response, ResultStatus.Error(exception.message))

            coVerify(exactly = 1) { breweryDetailDataSource.getBreweryById("id") }
        }

    @Test
    fun `GIVEN BreweryDetailRepository WHEN trying to call getBreweryById() from both datasources AND they throws exception SHOULD return error`() =
        runBlocking {

            val exception = Exception()

            coEvery { breweryDetailDataSource.getBreweryById("id") } throws IOException()
            coEvery { breweryDetailLocalDataSource.getBreweryById("id") } throws exception

            val response = breweryDetailRepository.getBreweryById("id")
            Assert.assertEquals(response, ResultStatus.Error(exception.message))

            coVerify(exactly = 1) { breweryDetailDataSource.getBreweryById("id") }
            coVerify(exactly = 1) { breweryDetailLocalDataSource.getBreweryById("id") }
        }

    companion object {
        const val errorMessage = "No data available"
    }
}