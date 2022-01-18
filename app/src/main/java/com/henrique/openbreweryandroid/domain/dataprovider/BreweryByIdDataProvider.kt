package com.henrique.openbreweryandroid.domain.dataprovider

import com.henrique.openbreweryandroid.domain.entity.BreweryEntity

interface BreweryByIdDataProvider {
    suspend fun searchBreweryById(id: String) : BreweryEntity
}