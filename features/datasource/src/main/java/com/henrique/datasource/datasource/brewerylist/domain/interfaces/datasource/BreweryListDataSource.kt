package com.henrique.datasource.datasource.brewerylist.domain.interfaces.datasource

import com.henrique.datasource.data.remote.response.BreweryResponse

interface BreweryListDataSource {
    suspend fun getBreweryList() : List<BreweryResponse>
}