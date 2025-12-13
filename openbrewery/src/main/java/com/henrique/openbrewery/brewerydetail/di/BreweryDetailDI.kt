package com.henrique.openbrewery.brewerydetail.di

import com.henrique.openbrewery.brewerydetail.data.repository.BreweryDetailRepositoryImpl
import com.henrique.openbrewery.brewerydetail.data.service.BreweryDetailService
import com.henrique.openbrewery.brewerydetail.domain.interfaces.BreweryDetailRepository
import com.henrique.openbrewery.brewerydetail.domain.usecase.BreweryDetailUseCase
import com.henrique.openbrewery.brewerydetail.domain.usecase.BreweryDetailUseCaseImpl
import com.henrique.openbrewery.brewerydetail.presentation.viewmodel.BreweryDetailViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit

object BreweryDetailDI {

    private val services: Module = module {
        factory<BreweryDetailService> {
            get<Retrofit>().create(BreweryDetailService::class.java)
        }
    }

    private val repositories: Module = module {
        factory<BreweryDetailRepository> { BreweryDetailRepositoryImpl(get()) }
    }

    private val useCases: Module = module {
        factory<BreweryDetailUseCase> { BreweryDetailUseCaseImpl(get()) }
    }

    private val viewModels: Module = module {
        viewModelOf(::BreweryDetailViewModel)
    }

    val module = services + repositories + useCases + viewModels
}
