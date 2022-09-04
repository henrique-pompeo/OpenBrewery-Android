package com.henrique.openbrewery.infrastructure

import com.henrique.datasource.brewerylist.domain.interfaces.datasource.BreweryListLocalDataSource
import com.henrique.datasource.brewerylist.data.datasource.BreweryListLocalDataSourceImpl
import com.henrique.datasource.brewerylist.domain.interfaces.datasource.BreweryListDataSource
import com.henrique.datasource.brewerylist.data.datasource.BreweryListDataSourceImpl
import com.henrique.openbrewery.features.brewerylist.presentation.viewmodel.BreweryListViewModel
import com.henrique.datasource.brewerylist.domain.interfaces.repository.BreweryListRepository
import com.henrique.datasource.brewerylist.data.repository.BreweryListRepositoryImpl
import com.henrique.datasource.brewerylist.data.service.BreweryListService
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