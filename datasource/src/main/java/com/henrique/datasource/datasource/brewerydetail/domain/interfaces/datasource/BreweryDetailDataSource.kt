package com.henrique.datasource.datasource.brewerydetail.domain.interfaces.datasource

import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail

interface BreweryDetailDataSource {
    suspend fun getBreweryDetails(id: String): BreweryDetail
}