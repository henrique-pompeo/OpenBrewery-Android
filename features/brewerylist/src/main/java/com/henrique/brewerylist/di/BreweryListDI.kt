package com.henrique.brewerylist.di

import com.henrique.brewerylist.data.datasource.BreweryListDataSource
import com.henrique.brewerylist.data.datasource.BreweryListDataSourceImpl
import com.henrique.brewerylist.ui.BreweryListViewModel
import com.henrique.brewerylist.data.repository.BreweryListRepository
import com.henrique.brewerylist.data.repository.BreweryListRepositoryImpl
import com.henrique.brewerylist.data.service.BreweryListService
import org.koin.dsl.module
import org.koin.core.component.KoinApiExtension
import org.koin.androidx.viewmodel.dsl.viewModel
import retrofit2.Retrofit

@KoinApiExtension
object BreweryListDI {

    val module = module {
        single<BreweryListService> { get<Retrofit>().create(BreweryListService::class.java) }
        single<BreweryListDataSource> { BreweryListDataSourceImpl(get()) }
        single<BreweryListRepository> { BreweryListRepositoryImpl(get()) }
        viewModel { BreweryListViewModel(get()) }
    }
}