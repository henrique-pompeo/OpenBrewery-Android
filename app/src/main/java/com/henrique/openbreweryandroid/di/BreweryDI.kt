package com.henrique.openbreweryandroid.di

import com.henrique.openbreweryandroid.BuildConfig
import com.henrique.openbreweryandroid.app.feature.brewerylist.BreweryListViewModel
import com.henrique.openbreweryandroid.data.dataprovider.BreweryByIdDataProviderImpl
import com.henrique.openbreweryandroid.data.dataprovider.BreweryListDataProviderImpl
import com.henrique.openbreweryandroid.data.dataprovider.SearchBreweryDataProviderImpl
import com.henrique.openbreweryandroid.data.repository.BreweryRepository
import com.henrique.openbreweryandroid.data.repository.BreweryRepositoryImpl
import com.henrique.openbreweryandroid.domain.dataprovider.BreweryByIdDataProvider
import com.henrique.openbreweryandroid.domain.dataprovider.BreweryListDataProvider
import com.henrique.openbreweryandroid.domain.dataprovider.SearchBreweryDataProvider
import com.squareup.moshi.Moshi
import org.koin.dsl.module
import org.koin.core.component.KoinApiExtension
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@KoinApiExtension
object BreweryDI {

    val module = module {

        factory { BreweryListViewModel(get()) }

        factory<BreweryByIdDataProvider> { BreweryByIdDataProviderImpl(get()) }
        factory<BreweryListDataProvider> { BreweryListDataProviderImpl(get()) }
        factory<SearchBreweryDataProvider> { SearchBreweryDataProviderImpl(get()) }

        single<BreweryRepository> { BreweryRepositoryImpl() }

        single<Retrofit> {
            Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }

    }

}