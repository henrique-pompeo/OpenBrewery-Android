package com.henrique.datasource.brewerylist.domain.interfaces.datasource

import com.henrique.datasource.data.database.entity.BreweryEntity

interface BreweryListLocalDataSource {
    suspend fun getBreweryList() : List<BreweryEntity>
    suspend fun insertBreweryList(breweryList: List<BreweryEntity>)
}
