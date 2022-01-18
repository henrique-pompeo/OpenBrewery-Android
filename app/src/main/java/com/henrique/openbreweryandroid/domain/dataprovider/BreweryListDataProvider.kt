package com.henrique.openbreweryandroid.domain.dataprovider

import com.henrique.openbreweryandroid.domain.entity.BreweryEntity

interface BreweryListDataProvider {
    suspend fun getBreweryList() : List<BreweryEntity>
}