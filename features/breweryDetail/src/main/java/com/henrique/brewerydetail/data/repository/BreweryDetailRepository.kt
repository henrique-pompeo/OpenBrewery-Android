package com.henrique.brewerydetail.data.repository

import com.henrique.shared.domain.model.Brewery

interface BreweryDetailRepository {
    suspend fun getBreweryById(id: String) : Brewery
}