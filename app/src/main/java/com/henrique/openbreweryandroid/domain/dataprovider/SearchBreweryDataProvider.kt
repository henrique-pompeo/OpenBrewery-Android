package com.henrique.openbreweryandroid.domain.dataprovider

import com.henrique.openbreweryandroid.domain.entity.BreweryEntity

interface SearchBreweryDataProvider {
    suspend fun searchBrewery(search: String, query: String) : List<BreweryEntity>
}