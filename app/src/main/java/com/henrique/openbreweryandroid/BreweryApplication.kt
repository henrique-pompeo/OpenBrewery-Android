package com.henrique.openbreweryandroid

import android.app.Application
import com.henrique.openbreweryandroid.di.BreweryDI
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
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
            modules(
                BreweryDI.module
            ).androidContext(
                provideAndroidContext()
            ).androidLogger()
        }
    }

    private fun provideAndroidContext(): Application = this
}