package com.henrique.brewerylist.di

import com.henrique.brewerylist.ui.brewerylist.BreweryListViewModel
import com.henrique.brewerylist.data.repository.BreweryRepository
import com.henrique.brewerylist.data.repository.BreweryRepositoryImpl
import com.henrique.brewerylist.BuildConfig.BASE_URL
import com.henrique.brewerylist.data.service.BreweryService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import org.koin.core.component.KoinApiExtension
import retrofit2.Retrofit
import org.koin.androidx.viewmodel.dsl.viewModel
import retrofit2.converter.gson.GsonConverterFactory

@KoinApiExtension
object BreweryDI {

    val retrofitModule = module {
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
        single<BreweryService> { get<Retrofit>().create(BreweryService::class.java) }
    }

    val module = module {

        single<BreweryRepository> { BreweryRepositoryImpl(get()) }

        viewModel { BreweryListViewModel(get()) }
    }

}