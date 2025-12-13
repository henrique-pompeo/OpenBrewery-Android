package com.henrique.app

import android.app.Application
import com.henrique.openbrewery.di.OpenBreweryDI
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class BreweryApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@BreweryApplication)
            modules(
                OpenBreweryDI.module
            )
        }
    }
}