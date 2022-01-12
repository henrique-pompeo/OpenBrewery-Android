package com.henrique.openbreweryandroid.di

import com.henrique.openbreweryandroid.domain.gateway.GetBreweryByIdGateway
import com.henrique.openbreweryandroid.domain.gateway.GetBreweryListGateway
import com.henrique.openbreweryandroid.domain.gateway.SearchBreweryGateway
import com.henrique.openbreweryandroid.domain.usecase.GetBreweryByIdUseCase
import com.henrique.openbreweryandroid.domain.usecase.GetBreweryListUseCase
import com.henrique.openbreweryandroid.domain.usecase.SearchBreweryUseCase
import org.koin.dsl.module

object DomainDI {

    val module = module(override = true) {
        factory<GetBreweryByIdGateway> { GetBreweryByIdUseCase(get()) }
        factory<GetBreweryListGateway> { GetBreweryListUseCase(get()) }
        factory<SearchBreweryGateway> { SearchBreweryUseCase(get()) }
    }

}