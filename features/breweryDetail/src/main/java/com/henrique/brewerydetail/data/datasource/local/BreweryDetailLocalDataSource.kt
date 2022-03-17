package com.henrique.brewerydetail.data.datasource.local

import com.henrique.shared.data.database.entity.BreweryEntity

interface BreweryDetailLocalDataSource {
    suspend fun getBreweryById(id: String) : BreweryEntity?
}