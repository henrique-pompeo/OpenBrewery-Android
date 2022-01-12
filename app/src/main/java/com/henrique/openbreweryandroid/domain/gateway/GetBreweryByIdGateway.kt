package com.henrique.openbreweryandroid.domain.gateway

import com.henrique.openbreweryandroid.domain.entity.BreweryEntity

interface GetBreweryByIdGateway {
    suspend fun searchBreweryById(id: String) : BreweryEntity
}