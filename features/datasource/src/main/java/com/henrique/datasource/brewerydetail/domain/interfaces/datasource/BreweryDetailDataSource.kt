package com.henrique.datasource.brewerydetail.domain.interfaces.datasource

import com.henrique.datasource.data.remote.response.BreweryResponse

interface BreweryDetailDataSource {
    suspend fun getBreweryById(id: String) : BreweryResponse?
}