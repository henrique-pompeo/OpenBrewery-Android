package com.henrique.brewerylist.data.datasource.remote

import com.henrique.shared.data.remote.response.BreweryResponse

interface BreweryListDataSource {
    suspend fun getBreweryList() : List<BreweryResponse>
}