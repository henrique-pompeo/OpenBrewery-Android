package com.henrique.brewerylist.data.repository

import com.henrique.brewerylist.data.datasource.remote.BreweryListDataSource
import com.henrique.brewerylist.BreweryListTest
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
class BreweryListRepositoryImplTest : BreweryListTest() {

    private val breweryListDataSource = mockk<BreweryListDataSource>()

    @Test
    fun `GIVEN BreweryListRepository WHEN getBreweryList() is called SHOULD return a list of Brewery`() {

        breweryListRepository = BreweryListRepositoryImpl(breweryListDataSource)

        coEvery { breweryListDataSource.getBreweryList() } returns listOf(brewery)

        val response = runBlocking { breweryListRepository.getBreweryList() }

        Assert.assertEquals(response, listOf(brewery))

        coVerify(exactly = 1) { breweryListDataSource.getBreweryList() }

        confirmVerified(breweryListDataSource)
    }
}