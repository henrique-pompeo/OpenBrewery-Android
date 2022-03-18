package com.henrique.brewerylist.data.datasource.local

import com.henrique.brewerylist.UnitTest
import com.henrique.shared.data.database.dao.BreweryDao
import com.henrique.shared.data.extensions.model
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.koin.core.component.KoinApiExtension

@ExperimentalCoroutinesApi
@KoinApiExtension
class BreweryListLocalDataSourceImplTest : UnitTest() {

    private val breweryDao = mockk<BreweryDao>()
    private val breweryListLocalDataSource = BreweryListLocalDataSourceImpl(breweryDao)

    @Test
    fun `GIVEN BreweryListLocalDataSource WHEN getBreweryList() is called SHOULD return a list of BreweryEntity`() =
        runBlocking {

            coEvery { breweryDao.getBreweryList() }  returns listOf(breweryEntity)

            val response = breweryListLocalDataSource.getBreweryList()
            Assert.assertEquals(response.map { it.model() }, listOf(breweryEntity).map { it.model() })

            coVerify(exactly = 1) { breweryDao.getBreweryList() }
    }

    @Test
    fun `GIVEN BreweryListLocalDataSource WHEN insertBreweryList() is called SHOULD insert a list of BreweryEntity in the database`() =
        runBlocking {

            coEvery { breweryDao.getBreweryList() }  returns listOf(breweryEntity)
            coEvery { breweryDao.insertBreweryList(breweryList = listOf(breweryEntity)) } just Runs

            breweryListLocalDataSource.insertBreweryList(listOf(breweryEntity))

            val response = runBlocking { breweryListLocalDataSource.getBreweryList() }

            Assert.assertEquals(response.map { it.model() }, listOf(breweryEntity).map { it.model() })
    }

}