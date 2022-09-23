package com.henrique.datasource.dataprovider.providers.database.openbrewery.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.henrique.datasource.InstrumentedTest
import com.henrique.datasource.dataprovider.providers.database.openbrewery.configuration.AppDatabase

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

    override fun onTearDown() {
        super.onTearDown()
        db.close()
    }
}
