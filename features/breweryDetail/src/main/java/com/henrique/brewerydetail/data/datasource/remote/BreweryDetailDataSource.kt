package com.henrique.brewerydetail.data.datasource.remote

import com.henrique.shared.data.remote.response.BreweryResponse

interface BreweryDetailDataSource {
    suspend fun getBreweryById(id: String) : BreweryResponse?
}