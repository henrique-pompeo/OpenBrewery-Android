package com.henrique.openbrewery.infrastructure

import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDatabaseProvider
import com.henrique.datasource.datasource.brewerydetail.data.datasource.BreweryDetailDatabaseProviderImpl
import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDataSource
import com.henrique.datasource.datasource.brewerydetail.data.datasource.BreweryDetailDataSourceImpl
import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.repository.BreweryDetailRepository
import com.henrique.datasource.datasource.brewerydetail.data.repository.BreweryDetailRepositoryImpl
import com.henrique.datasource.datasource.brewerydetail.data.service.BreweryDetailService
import com.henrique.openbrewery.features.brewerydetail.presentation.viewmodel.BreweryDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.component.KoinApiExtension
import org.koin.dsl.module
import retrofit2.Retrofit

@KoinApiExtension
object BreweryDetailDI {

    val module = module {
        single<BreweryDetailService> { get<Retrofit>().create(BreweryDetailService::class.java) }
        single<BreweryDetailDataSource> { BreweryDetailDataSourceImpl(get()) }
        single<BreweryDetailDatabaseProvider> { BreweryDetailDatabaseProviderImpl(get()) }
        single<BreweryDetailRepository> { BreweryDetailRepositoryImpl(get(), get()) }
        viewModel { BreweryDetailViewModel(get()) }
    }

}