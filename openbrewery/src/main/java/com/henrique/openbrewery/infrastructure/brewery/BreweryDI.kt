package com.henrique.openbrewery.infrastructure.brewery

import com.henrique.openbrewery.domain.brewery.mappers.BreweryMapper
import org.koin.dsl.module
import org.koin.core.module.Module

object BreweryDI {
    private val mappers: Module = module {
        factory { BreweryMapper() }
    }

    val module = mappers
}
