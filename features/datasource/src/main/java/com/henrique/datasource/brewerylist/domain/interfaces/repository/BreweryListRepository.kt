package com.henrique.datasource.brewerylist.domain.interfaces.repository

import com.henrique.datasource.brewerydetail.domain.model.BreweryStatus
import com.henrique.datasource.data.database.entity.BreweryEntity
import com.henrique.datasource.brewerydetail.domain.model.Brewery

interface BreweryListRepository {
    suspend fun getBreweryList() : BreweryStatus<List<Brewery>>
    suspend fun insertBreweryList(breweryList: List<BreweryEntity>)
}