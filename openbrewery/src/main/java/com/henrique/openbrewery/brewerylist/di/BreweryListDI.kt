package com.henrique.openbrewery.brewerylist.di

import com.henrique.openbrewery.brewerylist.data.repository.BreweryListRepositoryImpl
import com.henrique.openbrewery.brewerylist.data.service.BreweryListService
import com.henrique.openbrewery.brewerylist.domain.interfaces.repository.BreweryListRepository
import com.henrique.openbrewery.brewerylist.domain.usecase.BreweryListUseCase
import com.henrique.openbrewery.brewerylist.domain.usecase.BreweryListUseCaseImpl
import com.henrique.openbrewery.brewerylist.presentation.adapter.BreweryListAdapter
import com.henrique.openbrewery.brewerylist.presentation.viewmodel.BreweryListViewModel
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

    private val repositories: Module = module {
        factory<BreweryListRepository> { BreweryListRepositoryImpl(get()) }
    }

    private val useCases: Module = module {
        factory<BreweryListUseCase> { BreweryListUseCaseImpl(get()) }
    }

    private val viewModels: Module = module {
        viewModelOf(::BreweryListViewModel)
    }

    private val adapters: Module = module {
        factory { BreweryListAdapter(get(), get()) }
    }

    val module = services + repositories + useCases + viewModels + adapters
}
