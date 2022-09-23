package com.henrique.datasource.datasource.infrastructure

import com.henrique.datasource.BuildConfig.BASE_URL
import com.henrique.datasource.datasource.brewerydetail.infrastructure.BreweryDetailDI
import com.henrique.datasource.datasource.brewerylist.infrastructure.BreweryListDI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import org.koin.core.module.Module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DatasourceDI {

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

    val module = retrofit +
            BreweryListDI.module +
            BreweryDetailDI.module
}
