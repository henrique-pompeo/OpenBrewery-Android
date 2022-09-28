package com.henrique.datasource.datasource.brewerylist.infrastructure

import com.henrique.datasource.datasource.brewerylist.data.datasource.BreweryListDataSourceImpl
import com.henrique.datasource.datasource.brewerylist.data.datasource.BreweryListDatabaseProviderImpl
import com.henrique.datasource.datasource.brewery.data.mappers.BreweryMapper
import com.henrique.datasource.datasource.brewerylist.data.repository.BreweryListRepositoryImpl
import com.henrique.datasource.datasource.brewerylist.data.service.BreweryListService
import com.henrique.datasource.datasource.brewerylist.domain.interfaces.datasource.BreweryListDataSource
import com.henrique.datasource.datasource.brewerylist.domain.interfaces.datasource.BreweryListDatabaseProvider
import com.henrique.datasource.datasource.brewerylist.domain.interfaces.repository.BreweryListRepository
import org.koin.dsl.module
import org.koin.core.module.Module
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

    private val mappers: Module = module {
        factory { BreweryMapper() }
    }

    val module = services + datasources + repositories + mappers
}
