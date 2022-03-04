package com.henrique.brewerylist.data.repository

import com.henrique.shared.data.database.entities.BreweryEntity
import com.henrique.shared.domain.model.Brewery

interface BreweryListRepository {
    suspend fun getBreweryList() : List<Brewery>
    suspend fun getBreweryListLocal() : List<Brewery>
    suspend fun insertBrewery(breweryEntity: BreweryEntity)
    suspend fun updateBrewery(brewery: BreweryEntity)
    suspend fun deleteBrewery(breweryEntity: BreweryEntity)
}