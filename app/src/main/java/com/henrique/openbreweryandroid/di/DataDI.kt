package com.henrique.openbreweryandroid.di

import com.henrique.openbreweryandroid.BuildConfig
import com.henrique.openbreweryandroid.data.dataprovider.GetBreweryByIdDataProvider
import com.henrique.openbreweryandroid.data.dataprovider.GetBreweryListDataProvider
import com.henrique.openbreweryandroid.data.dataprovider.SearchBreweryDataProvider
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object DataDI {
    val module = module(override = true) {

        factory<GetBreweryByIdDataProvider> { GetBreweryByIdDataProvider(get()) }
        factory<GetBreweryListDataProvider> { GetBreweryListDataProvider(get()) }
        factory<SearchBreweryDataProvider> { SearchBreweryDataProvider(get()) }

        single<Retrofit> {
            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }
    }
}