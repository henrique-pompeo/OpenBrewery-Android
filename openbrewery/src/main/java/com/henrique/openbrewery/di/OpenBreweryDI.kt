package com.henrique.openbrewery.di

import com.henrique.openbrewery.brewerylist.di.BreweryListDI
import com.henrique.openbrewery.brewerydetail.di.BreweryDetailDI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object OpenBreweryDI {

    private const val BASE_URL = "https://api.openbrewerydb.org/v1/breweries/"

    private val retrofit: Module = module {
        single<Retrofit> {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        single {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
        }
    }

    val module = retrofit + BreweryListDI.module + BreweryDetailDI.module
}
