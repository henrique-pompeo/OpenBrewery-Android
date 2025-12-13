package com.henrique.datasource.datasource.brewerydetail.domain.interfaces.repository

import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail

interface BreweryDetailRepository {
    suspend fun getBreweryDetails(id: String): BreweryDetail
    suspend fun getDatabaseBreweryDetails(id: String): BreweryDetail
}