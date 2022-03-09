package com.henrique.shared.data.database.configuration

import androidx.room.Database
import androidx.room.RoomDatabase
import com.henrique.shared.data.database.dao.BreweryDao
import com.henrique.shared.data.database.entities.BreweryEntity

@Database(entities = [BreweryEntity::class], version = AppDatabase.VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val VERSION = 3
        const val FILE_NAME = "brewery.db"
    }

    abstract fun brewertDao(): BreweryDao
}