package com.henrique.openbreweryandroid.domain.usecase

import com.henrique.openbreweryandroid.domain.entity.BreweryEntity
import com.henrique.openbreweryandroid.domain.gateway.GetBreweryByIdGateway

class GetBreweryByIdUseCase(private val gateway: GetBreweryByIdGateway) : GetBreweryByIdGateway {
    override suspend fun searchBreweryById(id: String): BreweryEntity {
        return gateway.searchBreweryById(id)
    }
}