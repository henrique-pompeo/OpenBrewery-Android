package com.henrique.openbrewery.infrastructure

import com.henrique.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailLocalDataSource
import com.henrique.datasource.brewerydetail.data.datasource.BreweryDetailLocalDataSourceImpl
import com.henrique.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDataSource
import com.henrique.datasource.brewerydetail.data.datasource.BreweryDetailDataSourceImpl
import com.henrique.datasource.brewerydetail.domain.interfaces.repository.BreweryDetailRepository
import com.henrique.datasource.brewerydetail.data.repository.BreweryDetailRepositoryImpl
import com.henrique.datasource.brewerydetail.domain.interfaces.service.BreweryDetailService
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
        single<BreweryDetailLocalDataSource> { BreweryDetailLocalDataSourceImpl(get()) }
        single<BreweryDetailRepository> { BreweryDetailRepositoryImpl(get(), get()) }
        viewModel { BreweryDetailViewModel(get()) }
    }

}