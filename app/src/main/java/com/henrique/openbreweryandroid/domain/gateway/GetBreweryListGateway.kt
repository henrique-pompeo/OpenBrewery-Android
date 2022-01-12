package com.henrique.openbreweryandroid.domain.gateway

import com.henrique.openbreweryandroid.domain.entity.BreweryEntity

interface GetBreweryListGateway {
    suspend fun getBreweryList() : List<BreweryEntity>
}