package com.henrique.brewerylist.di

import com.henrique.brewerylist.data.datasource.local.BreweryListLocalDataSource
import com.henrique.brewerylist.data.datasource.local.BreweryListLocalDataSourceImpl
import com.henrique.brewerylist.data.datasource.remote.BreweryListDataSource
import com.henrique.brewerylist.data.datasource.remote.BreweryListDataSourceImpl
import com.henrique.brewerylist.ui.viewmodel.BreweryListViewModel
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
        single<BreweryListLocalDataSource> { BreweryListLocalDataSourceImpl(get()) }

        single<BreweryListRepository> { BreweryListRepositoryImpl(get(), get()) }

        viewModel { BreweryListViewModel(get()) }
    }
}