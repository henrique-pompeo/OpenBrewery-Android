package com.henrique.brewerydetail.di

import com.henrique.brewerydetail.data.datasource.BreweryDetailDataSource
import com.henrique.brewerydetail.data.datasource.BreweryDetailDataSourceImpl
import com.henrique.brewerydetail.data.repository.BreweryDetailRepository
import com.henrique.brewerydetail.data.repository.BreweryDetailRepositoryImpl
import com.henrique.brewerydetail.data.service.BreweryDetailService
import com.henrique.brewerydetail.ui.BreweryDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.component.KoinApiExtension
import org.koin.dsl.module
import retrofit2.Retrofit

@KoinApiExtension
object BreweryDetailDI {

    val module = module {
        single<BreweryDetailService> { get<Retrofit>().create(BreweryDetailService::class.java) }
        single<BreweryDetailDataSource> { BreweryDetailDataSourceImpl(get()) }
        single<BreweryDetailRepository> { BreweryDetailRepositoryImpl(get()) }
        viewModel { BreweryDetailViewModel(get()) }
    }

}