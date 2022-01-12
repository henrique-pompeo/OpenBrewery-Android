package com.henrique.openbreweryandroid.domain.usecase

import com.henrique.openbreweryandroid.domain.entity.BreweryEntity
import com.henrique.openbreweryandroid.domain.gateway.GetBreweryListGateway

class GetBreweryListUseCase(private val gateway: GetBreweryListGateway) : GetBreweryListGateway {
    override suspend fun getBreweryList(): List<BreweryEntity> {
        return gateway.getBreweryList()
    }
}