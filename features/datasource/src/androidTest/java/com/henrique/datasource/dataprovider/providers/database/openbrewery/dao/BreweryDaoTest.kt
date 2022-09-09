package com.henrique.datasource.dataprovider.providers.database.openbrewery.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.henrique.datasource.InstrumentedTest
import com.henrique.datasource.dataprovider.providers.database.openbrewery.configuration.AppDatabase
import com.henrique.datasource.dataprovider.providers.database.openbrewery.entity.BreweryEntity
import com.henrique.datasource.data.extensions.model
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryDaoTest : InstrumentedTest() {

    private lateinit var db: AppDatabase
    private lateinit var breweryDao: BreweryDao

    override fun onSetUp() {
        super.onSetUp()
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        ).build()
        breweryDao = db.breweryDao()
    }

    @Test
    fun givenBreweryListWhenInsertedAndGottenInTheDatabaseShouldReturnBreweryList() =
        runBlocking {

            val breweryList: List<BreweryEntity> = listOf(breweryEntity)

            breweryDao.insertBreweryList(breweryList)
            val result = breweryDao.getBreweryList()

            assertEquals(result.map { it.model() }, breweryList.map { it.model() })
        }

    @Test
    fun givenBreweryListWhenInsertedAndRequestedBreweryByIdInTheDatabaseShouldReturnCorrectBrewery() =
        runBlocking {

            val breweryList: List<BreweryEntity> = listOf(breweryEntity)

            breweryDao.insertBreweryList(breweryList)
            val result = breweryDao.getBreweryDetails("id")

            assertEquals(result?.model(), breweryEntity.model())
        }

    override fun onTearDown() {
        super.onTearDown()
        db.close()
    }
}
