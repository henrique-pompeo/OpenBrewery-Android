package com.henrique.openbreweryandroid.di

import com.henrique.openbreweryandroid.app.feature.brewerylist.BreweryListViewModel
import com.henrique.data.source.Network
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
object ApplicationDI {

    val module = module {

        viewModel {
            BreweryListViewModel(get())
        }

        single { Network.createGetBreweriesUseCase(get()) }

        single { Network.createBreweriesRepository(get()) }

    }

}