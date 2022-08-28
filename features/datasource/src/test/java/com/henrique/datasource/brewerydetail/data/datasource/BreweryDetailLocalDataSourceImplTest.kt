package com.henrique.datasource.brewerydetail.data.datasource

import com.henrique.datasource.base.UnitTest
import com.henrique.datasource.brewerydetail.data.datasource.BreweryDetailLocalDataSourceImpl
import com.henrique.datasource.data.database.dao.BreweryDao
import com.henrique.datasource.data.extensions.model
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.koin.core.component.KoinApiExtension

@ExperimentalCoroutinesApi
@KoinApiExtension
class BreweryDetailLocalDataSourceImplTest : com.henrique.datasource.base.UnitTest() {

    private val breweryDao = mockk<BreweryDao>()
    private val breweryDetailLocalDataSource = BreweryDetailLocalDataSourceImpl(breweryDao)

    @Test
    fun `GIVEN BreweryDetailLocalDataSource WHEN getBreweryById() is called SHOULD return a BreweryEntity`() =
        runBlocking {

            coEvery { breweryDao.getBreweryById("id") }  returns breweryEntity

            val response = breweryDetailLocalDataSource.getBreweryById("id")
            Assert.assertEquals(response?.model() , breweryEntity.model() )

            coVerify(exactly = 1) { breweryDao.getBreweryById("id") }
    }

}