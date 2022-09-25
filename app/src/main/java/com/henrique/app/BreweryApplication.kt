package com.henrique.app

import android.app.Application
import com.henrique.datasource.infrastructure.DatasourceDI
import com.henrique.openbrewery.infrastructure.OpenBreweryDI
import org.koin.android.ext.koin.androidContext
import org.koin.android.java.KoinAndroidApplication
import org.koin.core.context.startKoin

class BreweryApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            KoinAndroidApplication.create(applicationContext)
            androidContext(this@BreweryApplication)
            modules(
                DatasourceDI.module +
                        OpenBreweryDI.module
            )
        }
    }
}