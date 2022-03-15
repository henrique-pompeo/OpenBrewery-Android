package com.henrique.brewerylist.data.repository

import com.henrique.brewerylist.data.datasource.remote.BreweryListDataSource
import com.henrique.brewerylist.UnitTest
import com.henrique.brewerylist.data.datasource.local.BreweryListLocalDataSource
import com.henrique.shared.data.ResultStatus
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
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
    fun `GIVEN BreweryListRepository WHEN getBreweryList() is called SHOULD return a list of Brewery and INSERT it into database`() =
        runBlocking {

        coEvery { breweryListDataSource.getBreweryList() } returns listOf(breweryResponse)
        coEvery { breweryListLocalDataSource.insertBreweryList(listOf(breweryEntity)) } just Runs
        coEvery { breweryListLocalDataSource.getBreweryList() } returns listOf(breweryEntity)

        val response = breweryListRepository.getBreweryList()

        Assert.assertEquals(response, ResultStatus.Success(listOf(brewery)))

        coVerify(exactly = 1) { breweryListDataSource.getBreweryList() }
    }

    @Test
    fun `GIVEN BreweryListRepository WHEN getBreweryList() is called and throws exception SHOULD return a list of Brewery from local database`() =
        runBlocking {

        coEvery { breweryListDataSource.getBreweryList() } throws IOException()
        coEvery { breweryListLocalDataSource.getBreweryList() } returns listOf(breweryEntity)

        val response = breweryListRepository.getBreweryList()

        Assert.assertEquals(response, ResultStatus.Success(listOf(brewery)))

        coVerify(exactly = 1) { breweryListDataSource.getBreweryList() }
    }

    @Test
    fun `GIVEN BreweryListRepository WHEN getBreweryList() is called throws exception for both datasources`() =
        runBlocking {

            val exception = Exception()

            coEvery { breweryListDataSource.getBreweryList() } throws IOException()
            coEvery { breweryListLocalDataSource.getBreweryList() } throws exception

            val response = breweryListRepository.getBreweryList()

            Assert.assertEquals(response, ResultStatus.Error(exception))

            coVerify(exactly = 1) { breweryListDataSource.getBreweryList() }
        }
}