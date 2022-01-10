package com.henrique.app

import android.app.Application
import com.henrique.app.di.ApplicationDI
import com.henrique.data.di.DataDI
import com.henrique.data.source.NetworkDI
import com.henrique.domain.di.DomainDI
import org.koin.core.component.KoinApiExtension
import org.koin.core.context.startKoin

class BreweryApplication : Application() {

    @KoinApiExtension
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                ApplicationDI.module +
                DataDI.module +
                DomainDI.module +
                NetworkDI.module
            )
        }

    }

}