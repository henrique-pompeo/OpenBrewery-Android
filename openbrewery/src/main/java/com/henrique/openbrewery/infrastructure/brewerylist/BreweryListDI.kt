package com.henrique.openbrewery.infrastructure.brewerylist

import com.henrique.openbrewery.domain.brewerylist.mappers.BreweryListItemMapper
import com.henrique.openbrewery.domain.brewerylist.usecase.BreweryListUseCase
import com.henrique.openbrewery.domain.brewerylist.usecase.BreweryListUseCaseImpl
import com.henrique.openbrewery.domain.navigation.BreweryNavigation
import com.henrique.openbrewery.presentation.brewerylist.adapter.BreweryListAdapter
import com.henrique.openbrewery.presentation.brewerylist.viewmodel.BreweryListViewModel
import com.henrique.openbrewery.presentation.navigation.BreweryNavigationImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.core.module.Module

object BreweryListDI {
    private val mappers: Module = module {
        factory { BreweryListItemMapper() }
    }

    private val useCases: Module = module {
        factory<BreweryListUseCase> { BreweryListUseCaseImpl(get(), get()) }
    }

    private val viewModels: Module = module {
        viewModel { BreweryListViewModel(get()) }
    }

    private val adapters: Module = module {
        factory { BreweryListAdapter(get(), get()) }
    }

    private val navigations: Module = module {
        factory<BreweryNavigation> { BreweryNavigationImpl(get()) }
    }

    val module = mappers + useCases + viewModels + adapters + navigations
}
