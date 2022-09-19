package com.henrique.datasource.datasource.brewerydetail.infrastructure

import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDatabaseProvider
import com.henrique.datasource.datasource.brewerydetail.data.datasource.BreweryDetailDatabaseProviderImpl
import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDataSource
import com.henrique.datasource.datasource.brewerydetail.data.datasource.BreweryDetailDataSourceImpl
import com.henrique.datasource.datasource.brewerydetail.data.mappers.BreweryDetailMapper
import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.repository.BreweryDetailRepository
import com.henrique.datasource.datasource.brewerydetail.data.repository.BreweryDetailRepositoryImpl
import com.henrique.datasource.datasource.brewerydetail.data.service.BreweryDetailService
import org.koin.core.component.KoinApiExtension
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

@KoinApiExtension
object BreweryDetailDI {

    private val services: Module = module {
        factory<BreweryDetailService> {
            get<Retrofit>().create(BreweryDetailService::class.java)
        }
    }

    private val datasources: Module = module {
        factory<BreweryDetailDataSource> { BreweryDetailDataSourceImpl(get(), get()) }
        factory<BreweryDetailDatabaseProvider> { BreweryDetailDatabaseProviderImpl(get(), get()) }
    }

    private val repositories: Module = module {
        factory<BreweryDetailRepository> { BreweryDetailRepositoryImpl(get(), get()) }
    }

    private val mappers: Module = module {
        factory { BreweryDetailMapper() }
    }

    val module = services + datasources + repositories + mappers
}
