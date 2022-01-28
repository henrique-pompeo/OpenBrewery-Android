package com.henrique.brewerylist.di

import com.henrique.brewerylist.ui.BreweryListViewModel
import com.henrique.brewerylist.data.repository.BreweryRepository
import com.henrique.brewerylist.data.repository.BreweryRepositoryImpl
import com.henrique.brewerylist.data.service.BreweryService
import org.koin.dsl.module
import org.koin.core.component.KoinApiExtension
import org.koin.androidx.viewmodel.dsl.viewModel
import retrofit2.Retrofit

@KoinApiExtension
object BreweryListDI {

    val module = module {
        single<BreweryService> { get<Retrofit>().create(BreweryService::class.java) }
        single<BreweryRepository> { BreweryRepositoryImpl(get()) }
        viewModel { BreweryListViewModel(get()) }
    }
}