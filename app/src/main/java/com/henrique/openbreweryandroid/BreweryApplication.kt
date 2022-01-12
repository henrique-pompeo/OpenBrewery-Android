package com.henrique.openbreweryandroid

import android.app.Application
import com.henrique.data.source.NetworkDI
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinApiExtension
import org.koin.core.context.startKoin

class BreweryApplication : Application() {

    @KoinApiExtension
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    @KoinApiExtension
    private fun setupKoin() {
        startKoin {
            modules(
                //ApplicationDI.module +
                        NetworkDI.module
            ).androidContext(
                provideAndroidContext()
            ).androidLogger()
        }
    }

    private fun provideAndroidContext(): Application = this
}