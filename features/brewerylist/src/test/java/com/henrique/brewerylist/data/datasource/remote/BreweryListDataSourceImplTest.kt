package com.henrique.brewerylist.data.datasource.remote

import com.henrique.brewerylist.data.service.BreweryListService
import com.henrique.brewerylist.UnitTest
import com.henrique.brewerylist.data.datasource.remote.BreweryListDataSource
import com.henrique.brewerylist.data.datasource.remote.BreweryListDataSourceImpl
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
class BreweryListDataSourceImplTest : UnitTest() {

    private lateinit var breweryListDataSource: BreweryListDataSource

    private val breweryListService = mockk<BreweryListService>()

    @Test
    fun `GIVEN BreweryListDataSource WHEN getBreweryList() is called SHOULD return a list of BreweryResponse`() {

        breweryListDataSource = BreweryListDataSourceImpl(breweryListService)

        coEvery { breweryListService.getBreweryList(any()) } returns listOf(breweryResponse)

        val response = runBlocking { breweryListDataSource.getBreweryList() }

        Assert.assertEquals(response, listOf(breweryResponse))

        coVerify(exactly = 1) { breweryListService.getBreweryList("") }

        confirmVerified(breweryListService)
    }
}