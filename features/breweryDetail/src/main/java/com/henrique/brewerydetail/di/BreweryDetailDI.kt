package com.henrique.brewerydetail.di

import com.henrique.brewerydetail.data.datasource.local.BreweryDetailLocalDataSource
import com.henrique.brewerydetail.data.datasource.local.BreweryDetailLocalDataSourceImpl
import com.henrique.brewerydetail.data.datasource.remote.BreweryDetailDataSource
import com.henrique.brewerydetail.data.datasource.remote.BreweryDetailDataSourceImpl
import com.henrique.brewerydetail.data.repository.BreweryDetailRepository
import com.henrique.brewerydetail.data.repository.BreweryDetailRepositoryImpl
import com.henrique.brewerydetail.data.service.BreweryDetailService
import com.henrique.brewerydetail.ui.viewmodel.BreweryDetailViewModel
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