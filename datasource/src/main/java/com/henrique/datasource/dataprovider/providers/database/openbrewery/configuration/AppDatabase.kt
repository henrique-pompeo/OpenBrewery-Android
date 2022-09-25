package com.henrique.datasource.dataprovider.providers.database.openbrewery.configuration

import androidx.room.Database
import androidx.room.RoomDatabase
import com.henrique.datasource.dataprovider.providers.database.openbrewery.dao.BreweryDao
import com.henrique.datasource.dataprovider.providers.database.openbrewery.entity.BreweryEntity

@Database(entities = [BreweryEntity::class], version = AppDatabase.VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val VERSION = 3
        const val FILE_NAME = "brewery.db"
    }

    abstract fun breweryDao(): BreweryDao
}