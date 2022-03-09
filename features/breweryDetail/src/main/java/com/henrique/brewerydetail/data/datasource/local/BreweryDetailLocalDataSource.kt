package com.henrique.brewerydetail.data.datasource.local

import com.henrique.shared.data.database.entities.BreweryEntity

interface BreweryDetailLocalDataSource {
    suspend fun getBreweryById(id: String) : BreweryEntity
}