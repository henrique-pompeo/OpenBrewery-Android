package com.henrique.brewerylist.data.datasource.local

import com.henrique.shared.data.database.entities.BreweryEntity
import com.henrique.shared.domain.model.Brewery

interface BreweryListLocalDataSource {
    suspend fun getBreweryList() : List<Brewery>
    suspend fun insertBrewery(breweryEntity: BreweryEntity)
    suspend fun updateBrewery(brewery: BreweryEntity)
    suspend fun deleteBrewery(breweryEntity: BreweryEntity)
}
