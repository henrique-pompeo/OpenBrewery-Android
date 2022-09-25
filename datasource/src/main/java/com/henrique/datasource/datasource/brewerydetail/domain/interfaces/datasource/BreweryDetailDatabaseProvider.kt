package com.henrique.datasource.datasource.brewerydetail.domain.interfaces.datasource

import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail

interface BreweryDetailDatabaseProvider {
    suspend fun getBreweryDetails(id: String) : BreweryDetail
}