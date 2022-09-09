package com.henrique.app

import android.app.Application
import com.henrique.openbrewery.infrastructure.BreweryDetailDI
import com.henrique.openbrewery.infrastructure.BreweryListDI
import com.henrique.datasource.dataprovider.providers.database.infrastructure.DatabaseDI
import com.henrique.datasource.datasource.infrastructure.DatasourceDI
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinApiExtension
import org.koin.core.context.startKoin

@KoinApiExtension
class BreweryApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@BreweryApplication)
            modules(
                DatasourceDI.module +
                DatabaseDI.module +
                BreweryListDI.module +
                BreweryDetailDI.module
            )
        }
    }
}