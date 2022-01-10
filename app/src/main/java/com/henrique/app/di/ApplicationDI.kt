package com.henrique.app.di

import com.henrique.app.ui.brewerylist.BreweryListViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
object ApplicationDI {

    val module = module {

        viewModel {
            BreweryListViewModel()
        }

    }

}