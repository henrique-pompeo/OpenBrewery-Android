package com.henrique.datasource.brewerydetail.domain.interfaces.repository

import com.henrique.datasource.brewerydetail.domain.model.BreweryStatus
import com.henrique.datasource.brewerydetail.domain.model.Brewery

interface BreweryDetailRepository {
    suspend fun getBreweryById(id: String) : BreweryStatus<Brewery>
}