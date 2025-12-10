package com.henrique.datasource.dataprovider.providers.database.openbrewery.dao

import android.content.Context
import android.os.Build
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.henrique.datasource.dataprovider.providers.database.openbrewery.configuration.AppDatabase
import com.henrique.datasource.util.StubFactory
import com.henrique.datasource.util.TestConstants
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class BreweryDaoTest {
    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val database: AppDatabase = Room.inMemoryDatabaseBuilder(
        context,
        AppDatabase::class.java
    ).build()
    private val breweryDao: BreweryDao = database.breweryDao()

    @Test
    fun `GIVEN BreweryDao WHEN getBreweryList() is called SHOULD return a list of BreweryEntity`() {
        runBlocking {
            breweryDao.insertBreweryList(StubFactory().breweryEntityList())
            val breweryList = breweryDao.getBreweryList()

            assert(breweryList == StubFactory().breweryEntityList())
        }
    }

    @Test
    fun `GIVEN BreweryDao WHEN getBreweryDetails() is called SHOULD return a BreweryEntity`() {
        runBlocking {
            breweryDao.insertBreweryList(StubFactory().breweryEntityList())
            val brewery = breweryDao.getBreweryDetails(TestConstants.id)

            assert(brewery == StubFactory().breweryEntity())
        }
    }

    @Test
    fun `GIVEN BreweryDao WHEN insertBreweryList() is called SHOULD insert a list of Brewery`() {
        runBlocking {
            var breweryList = breweryDao.getBreweryList()
            assert(breweryList.isEmpty())

            breweryDao.insertBreweryList(StubFactory().breweryEntityList())
            breweryList = breweryDao.getBreweryList()

            assert(breweryList == StubFactory().breweryEntityList())
        }
    }
}
