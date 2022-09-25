package com.henrique.openbrewery.infrastructure.navigation

import com.henrique.openbrewery.domain.navigation.BreweryNavigation
import com.henrique.openbrewery.presentation.navigation.BreweryNavigationImpl
import org.koin.core.module.Module
import org.koin.dsl.module

object NavigationDI {
    private val navigations: Module = module {
        factory<BreweryNavigation> { BreweryNavigationImpl(get()) }
    }

    val module = navigations
}