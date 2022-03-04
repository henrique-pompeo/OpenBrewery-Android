package com.henrique.shared.di

import androidx.room.Room
import com.henrique.shared.data.database.configuration.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinApiExtension
import org.koin.dsl.module

@KoinApiExtension
object DatabaseDI {

    val module = module {
        single {
            Room.databaseBuilder(
                androidContext(),
                AppDatabase::class.java,
                AppDatabase.FILE_NAME
            ).build()
        }
    }

}