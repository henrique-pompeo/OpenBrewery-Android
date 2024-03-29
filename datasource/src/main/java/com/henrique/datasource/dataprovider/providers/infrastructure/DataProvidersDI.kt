package com.henrique.datasource.dataprovider.providers.infrastructure

import androidx.room.Room
import com.henrique.datasource.dataprovider.providers.database.openbrewery.configuration.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

object DataProvidersDI {

    private val database: Module = module {
        single {
            Room.databaseBuilder(
                androidContext(),
                AppDatabase::class.java,
                AppDatabase.FILE_NAME
            ).build()
        }
        single { get<AppDatabase>().breweryDao() }
    }

    val module = database
}
