package com.henrique.datasource.brewerylist.domain.interfaces.repository

import com.henrique.datasource.data.ResultStatus
import com.henrique.datasource.data.database.entity.BreweryEntity
import com.henrique.datasource.domain.model.Brewery

interface BreweryListRepository {
    suspend fun getBreweryList() : ResultStatus<List<Brewery>>
    suspend fun insertBreweryList(breweryList: List<BreweryEntity>)
}