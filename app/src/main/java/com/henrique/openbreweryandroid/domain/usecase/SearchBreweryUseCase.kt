package com.henrique.openbreweryandroid.domain.usecase

import com.henrique.openbreweryandroid.domain.entity.BreweryEntity
import com.henrique.openbreweryandroid.domain.gateway.SearchBreweryGateway

class SearchBreweryUseCase(private val gateway: SearchBreweryGateway) : SearchBreweryGateway {
    override suspend fun searchBrewery(query: String): BreweryEntity {
        return gateway.searchBrewery(query)
    }
}