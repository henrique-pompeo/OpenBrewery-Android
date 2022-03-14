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

@ExperimentalCoroutinesApi
@KoinApiExtension
class BreweryListRepositoryImplTest : UnitTest() {

    private val breweryListDataSource = mockk<BreweryListDataSource>(relaxed = true)
    private val breweryListLocalDataSource = mockk<BreweryListLocalDataSource>(relaxed = true)
    private val breweryListRepository = BreweryListRepositoryImpl(
        breweryListDataSource, breweryListLocalDataSource
    )

    @Test
    fun `GIVEN BreweryListRepository WHEN getBreweryList() is called SHOULD return a list of Brewery and INSERT it into database`() {

        coEvery { breweryListDataSource.getBreweryList() } returns listOf(breweryResponse)
        coEvery { breweryListLocalDataSource.insertBreweryList(listOf(breweryEntity)) } just Runs
        coEvery { breweryListLocalDataSource.getBreweryList() } returns listOf(breweryEntity)

        val response = runBlocking { breweryListRepository.getBreweryList() }

        Assert.assertEquals(response, ResultStatus.Success(listOf(brewery)))

        coVerify(exactly = 1) { breweryListDataSource.getBreweryList() }
    }

    //TODO LIST
    // - FAIL TEST WHEN TRYING TO CALL getBreweryList FROM REMOTE AND SUCCESS CALLING FROM LOCAL DATABASE
    // - FAIL TEST WHEN TRYING TO CALL getBreweryList FROM REMOTE AND FAIL CALLING FROM LOCAL DATABASE
    // - VERIFY IF IT'S NEEDED TO TEST LOCAL DATABASE INSERTION
}