package com.henrique.brewerydetail.data.repository

import com.henrique.featurecommons.domain.model.Brewery

interface BreweryDetailRepository {
    suspend fun getBreweryById(id: String) : Brewery
}