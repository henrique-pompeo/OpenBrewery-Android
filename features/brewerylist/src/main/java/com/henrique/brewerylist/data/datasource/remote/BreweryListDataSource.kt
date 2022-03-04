package com.henrique.brewerylist.data.datasource.remote

import com.henrique.shared.domain.model.Brewery

interface BreweryListDataSource {
    suspend fun getBreweryList() : List<Brewery>
}