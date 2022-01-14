package com.henrique.openbreweryandroid.data.repository

import com.henrique.openbreweryandroid.domain.entity.BreweryEntity

interface BreweryRepository {
    suspend fun getBreweryById(id: String) : BreweryEntity?
    suspend fun getBreweryList() : List<BreweryEntity>?
    suspend fun searchBrewery(query: String) : List<BreweryEntity>?
}