package com.henrique.brewerylist.data.repository

import com.henrique.brewerylist.data.datasource.remote.BreweryListDataSource
import com.henrique.brewerylist.UnitTest
import com.henrique.brewerylist.data.datasource.local.BreweryListLocalDataSource
import com.henrique.shared.data.ResultStatus
import io.kotlintest.matchers.exactly
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import org.koin.core.component.KoinApiExtension
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import java.io.IOException

@ExperimentalCoroutinesApi
@KoinApiExtension
class BreweryListRepositoryImplTest : UnitTest() {

    private val breweryListDataSource = mockk<BreweryListDataSource>(relaxed = true)
    private val breweryListLocalDataSource = mockk<BreweryListLocalDataSource>(relaxed = true)
    private val breweryListRepository = BreweryListRepositoryImpl(
        breweryListDataSource, breweryListLocalDataSource
    )

    @Test
    fun `GIVEN BreweryListRepository WHEN getBreweryList() is called AND it returns a list SHOULD insert this list into database AND return success`() =
        runBlocking {

            coEvery { breweryListDataSource.getBreweryList() } returns listOf(breweryResponse)
            coEvery { breweryListLocalDataSource.insertBreweryList(any()) } just Runs

            val response = breweryListRepository.getBreweryList()

            Assert.assertEquals(response, ResultStatus.Success(listOf(brewery)))

            coVerify(exactly = 1) { breweryListDataSource.getBreweryList() }
            coVerify(exactly = 1) { breweryListLocalDataSource.insertBreweryList(any()) }
    }

    @Test
    fun `GIVEN BreweryListRepository WHEN getBreweryList() is called AND it returns an empty list SHOULD return error`() =
        runBlocking {

            coEvery { breweryListDataSource.getBreweryList() } returns listOf()

            val response = breweryListRepository.getBreweryList()

            Assert.assertEquals(response, ResultStatus.Error(errorMessage))

            coVerify(exactly = 1) { breweryListDataSource.getBreweryList() }
        }

    @Test
    fun `GIVEN BreweryListRepository WHEN getBreweryList() is called AND throws exception related to services SHOULD return success getting the list from local database`() =
        runBlocking {

        coEvery { breweryListDataSource.getBreweryList() } throws IOException()
        coEvery { breweryListLocalDataSource.getBreweryList() } returns listOf(breweryEntity)

        val response = breweryListRepository.getBreweryList()

        Assert.assertEquals(response, ResultStatus.Success(listOf(brewery)))

        coVerify(exactly = 1) { breweryListDataSource.getBreweryList() }
        coVerify(exactly = 1) { breweryListLocalDataSource.getBreweryList() }
    }

    @Test
    fun `GIVEN BreweryListRepository WHEN getBreweryList() is called AND throws exception not related to services SHOULD return error`() =
        runBlocking {

            val exception = Exception()

            coEvery { breweryListDataSource.getBreweryList() } throws exception

            val response = breweryListRepository.getBreweryList()

            Assert.assertEquals(response, ResultStatus.Error(exception.message))

            coVerify(exactly = 1) { breweryListDataSource.getBreweryList() }
        }

    @Test
    fun `GIVEN BreweryListRepository WHEN trying to call getBreweryList() from both datasources AND they throws exception SHOULD return error`() =
        runBlocking {

            val exception = Exception()

            coEvery { breweryListDataSource.getBreweryList() } throws IOException()
            coEvery { breweryListLocalDataSource.getBreweryList() } throws exception

            val response = breweryListRepository.getBreweryList()

            Assert.assertEquals(response, ResultStatus.Error(exception.message))

            coVerify(exactly = 1) { breweryListDataSource.getBreweryList() }
            coVerify(exactly = 1) { breweryListLocalDataSource.getBreweryList() }
        }

    companion object {
        val errorMessage = "No data available"
    }
}