package com.henrique.openbrewery.brewerylist.di

import com.henrique.datasource.datasource.brewery.data.mappers.BreweryMapper
import com.henrique.openbrewery.brewerylist.data.datasource.BreweryListDataSourceImpl
import com.henrique.openbrewery.brewerylist.data.datasource.BreweryListDatabaseProviderImpl
import com.henrique.openbrewery.brewerylist.data.repository.BreweryListRepositoryImpl
import com.henrique.openbrewery.brewerylist.data.service.BreweryListService
import com.henrique.openbrewery.brewerylist.domain.interfaces.datasource.BreweryListDataSource
import com.henrique.openbrewery.brewerylist.domain.interfaces.datasource.BreweryListDatabaseProvider
import com.henrique.openbrewery.brewerylist.domain.interfaces.repository.BreweryListRepository
import com.henrique.openbrewery.brewerylist.presentation.adapter.BreweryListAdapter
import com.henrique.openbrewery.brewerylist.presentation.viewmodel.BreweryListViewModel
import com.henrique.openbrewery.brewerylist.domain.mappers.BreweryListItemMapper
import com.henrique.openbrewery.brewerylist.domain.usecase.BreweryListUseCase
import com.henrique.openbrewery.brewerylist.domain.usecase.BreweryListUseCaseImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit

object BreweryListDI {
    private val services: Module = module {
        factory<BreweryListService> {
            get<Retrofit>().create(BreweryListService::class.java)
        }
    }

    private val datasources: Module = module {
        factory<BreweryListDataSource> { BreweryListDataSourceImpl(get(), get()) }
        factory<BreweryListDatabaseProvider> { BreweryListDatabaseProviderImpl(get(), get()) }
    }

    private val repositories: Module = module {
        factory<BreweryListRepository> { BreweryListRepositoryImpl(get(), get()) }
    }

    private val breweryMapper: Module = module {
        factory { BreweryMapper() }
    }

    private val breweryListItemMapper: Module = module {
        factory { BreweryListItemMapper() }
    }

    private val useCases: Module = module {
        factory<BreweryListUseCase> { BreweryListUseCaseImpl(get(), get()) }
    }

    private val viewModels: Module = module {
        viewModelOf(::BreweryListViewModel)
    }

    private val adapters: Module = module {
        factory { BreweryListAdapter(get(), get()) }
    }

    val module = services + datasources + repositories + breweryMapper + breweryListItemMapper +
            useCases + viewModels + adapters
}