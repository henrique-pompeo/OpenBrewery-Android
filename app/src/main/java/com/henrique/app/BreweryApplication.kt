package com.henrique.app

import android.app.Application
import com.henrique.brewerydetail.di.BreweryDetailDI
import com.henrique.brewerylist.di.BreweryListDI
import com.henrique.shared.di.RetrofitDI
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
                RetrofitDI.module +
                BreweryListDI.module +
                BreweryDetailDI.module
            )
        }
    }
}