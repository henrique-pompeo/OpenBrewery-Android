package com.henrique.brewerylist.data.datasource

import com.henrique.brewerylist.data.service.remote.BreweryListService
import com.henrique.brewerylist.BreweryListTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import org.junit.Test
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.koin.core.component.KoinApiExtension

@ExperimentalCoroutinesApi
@KoinApiExtension
class BreweryListDataSourceImplTest : BreweryListTest() {

    private lateinit var breweryListDataSource: BreweryListDataSource

    private val breweryListService = mockk<BreweryListService>()

    @Test
    fun `GIVEN BreweryListDataSource WHEN getBreweryList() is called SHOULD return a list of Brewery`() {

        breweryListDataSource = BreweryListDataSourceImpl(breweryListService)

        coEvery { breweryListService.getBreweryList(any()) } returns listOf(breweryResponse)

        val response = runBlocking { breweryListDataSource.getBreweryList() }

        Assert.assertEquals(response, listOf(brewery))

        coVerify(exactly = 1) { breweryListService.getBreweryList("") }

        confirmVerified(breweryListService)
    }
}