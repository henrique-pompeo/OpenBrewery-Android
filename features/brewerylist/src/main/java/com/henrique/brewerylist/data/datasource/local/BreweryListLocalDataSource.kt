package com.henrique.brewerylist.data.datasource.local

import com.henrique.shared.data.database.entities.BreweryEntity

interface BreweryListLocalDataSource {
    suspend fun getBreweryList() : List<BreweryEntity>
    suspend fun insertBreweryList(breweryList: List<BreweryEntity>)
}
