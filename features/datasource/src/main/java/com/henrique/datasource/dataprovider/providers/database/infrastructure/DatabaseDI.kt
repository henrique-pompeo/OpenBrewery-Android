package com.henrique.datasource.dataprovider.providers.database.infrastructure

import androidx.room.Room
import com.henrique.datasource.dataprovider.providers.database.openbrewery.configuration.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinApiExtension
import org.koin.core.module.Module
import org.koin.dsl.module

@KoinApiExtension
object DatabaseDI {

    val module: Module = module {
        single {
            Room.databaseBuilder(
                androidContext(),
                AppDatabase::class.java,
                AppDatabase.FILE_NAME
            ).build()
        }
        single { get<AppDatabase>().breweryDao() }
    }

}