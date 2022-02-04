package com.henrique.brewerydetail.data.datasource

import com.henrique.shared.domain.model.Brewery

interface BreweryDetailDataSource {
    suspend fun getBreweryById(id: String) : Brewery
}