package com.henrique.datasource.brewerydetail.domain.interfaces.datasource

import com.henrique.datasource.data.database.entity.BreweryEntity

interface BreweryDetailLocalDataSource {
    suspend fun getBreweryById(id: String) : BreweryEntity?
}