package com.henrique.openbreweryandroid.domain.gateway

import com.henrique.openbreweryandroid.domain.entity.BreweryEntity

interface SearchBreweryGateway {
    suspend fun searchBrewery(query: String) : BreweryEntity
}