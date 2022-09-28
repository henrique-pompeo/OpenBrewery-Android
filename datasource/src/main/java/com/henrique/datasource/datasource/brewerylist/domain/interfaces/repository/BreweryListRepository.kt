package com.henrique.datasource.datasource.brewerylist.domain.interfaces.repository

import com.henrique.datasource.datasource.brewery.domain.model.Brewery

interface BreweryListRepository {
    suspend fun getBreweryList() : List<Brewery>
    suspend fun getDatabaseBreweryList() : List<Brewery>
    suspend fun insertBreweryList(breweryList: List<Brewery>)
}