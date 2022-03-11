package com.henrique.brewerylist.data.repository

import com.henrique.shared.data.ResultStatus
import com.henrique.shared.data.database.entities.BreweryEntity
import com.henrique.shared.domain.model.Brewery

interface BreweryListRepository {
    suspend fun getBreweryList() : ResultStatus<List<Brewery>>
    suspend fun insertBreweryList(breweryList: List<BreweryEntity>)
}