package com.henrique.datasource.datasource.brewerylist.domain.interfaces.datasource

import com.henrique.datasource.datasource.brewerylist.domain.model.Brewery

interface BreweryListDatabaseProvider {
    suspend fun getBreweryList() : List<Brewery>
    suspend fun insertBreweryList(breweryList: List<Brewery>)
}
