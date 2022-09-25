package com.henrique.datasource.datasource.brewerylist.data.datasource

import com.henrique.datasource.datasource.brewerylist.data.service.BreweryListService
import com.henrique.openbrewery.UnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import org.junit.Test
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.koin.core.component.KoinApiExtension

@ExperimentalCoroutinesApi
@KoinApiExtension
class BreweryListDataSourceImplTest : UnitTest() {

    private val breweryListService = mockk<BreweryListService>()
    private val breweryListDataSource = BreweryListDataSourceImpl(breweryListService)

    @Test
    fun `GIVEN BreweryListDataSource WHEN getBreweryList() is called SHOULD return a list of BreweryResponse`() {

        coEvery { breweryListService.getBreweryList(any()) } returns listOf(breweryResponse)

        val response = runBlocking { breweryListDataSource.getBreweryList() }
        Assert.assertEquals(response, listOf(breweryResponse))

        coVerify(exactly = 1) { breweryListService.getBreweryList("") }
    }
}