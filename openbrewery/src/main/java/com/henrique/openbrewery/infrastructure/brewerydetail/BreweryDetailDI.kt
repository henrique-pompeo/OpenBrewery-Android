package com.henrique.openbrewery.infrastructure.brewerydetail

import com.henrique.openbrewery.domain.brewerydetail.mappers.BreweryDetailItemMapper
import com.henrique.openbrewery.domain.brewerydetail.mappers.BreweryDetailMapper
import com.henrique.openbrewery.domain.brewerydetail.usecase.BreweryDetailUseCase
import com.henrique.openbrewery.domain.brewerydetail.usecase.BreweryDetailUseCaseImpl
import com.henrique.openbrewery.presentation.brewerydetail.viewmodel.BreweryDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object BreweryDetailDI {
    private val mappers: Module = module {
        factory { BreweryDetailMapper() }
        factory { BreweryDetailItemMapper() }
    }

    private val useCases: Module = module {
        factory<BreweryDetailUseCase> { BreweryDetailUseCaseImpl(get(), get()) }
    }

    private val viewModels: Module = module {
        viewModel { BreweryDetailViewModel(get()) }
    }

    val module = mappers + useCases + viewModels
}
