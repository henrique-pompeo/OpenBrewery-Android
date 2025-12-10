package com.henrique.openbrewery.brewerylist.domain.interfaces.datasource

import com.henrique.datasource.datasource.brewery.domain.model.Brewery

interface BreweryListDatabaseProvider {
    suspend fun getBreweryList() : List<Brewery>
    suspend fun insertBreweryList(breweryList: List<Brewery>)
}
