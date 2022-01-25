package com.henrique.app

import android.app.Application
import com.henrique.brewerylist.di.BreweryDI
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
                BreweryDI.retrofitModule +
                BreweryDI.module
            )
        }
    }
}