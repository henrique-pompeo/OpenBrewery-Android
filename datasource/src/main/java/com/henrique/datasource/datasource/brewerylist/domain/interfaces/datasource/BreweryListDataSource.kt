package com.henrique.datasource.datasource.brewerylist.domain.interfaces.datasource

import com.henrique.datasource.datasource.brewery.domain.model.Brewery

interface BreweryListDataSource {
    suspend fun getBreweryList() : List<Brewery>
}