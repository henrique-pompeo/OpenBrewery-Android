package com.henrique.app

import android.app.Application
import com.henrique.app.di.ApplicationDI
import com.henrique.data.source.NetworkDI
import org.koin.core.component.KoinApiExtension
import org.koin.core.context.startKoin

class BreweryApplication : Application() {

    @KoinApiExtension
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                ApplicationDI.module +
                NetworkDI.module
            )
        }

    }

}