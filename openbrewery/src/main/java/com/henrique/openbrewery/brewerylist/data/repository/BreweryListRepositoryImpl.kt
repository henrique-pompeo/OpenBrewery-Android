package com.henrique.openbrewery.brewerylist.data.repository

import com.henrique.openbrewery.brewerylist.domain.interfaces.datasource.BreweryListDatabaseProvider
import com.henrique.openbrewery.brewerylist.domain.interfaces.datasource.BreweryListDataSource
import com.henrique.openbrewery.brewerylist.domain.interfaces.repository.BreweryListRepository
import com.henrique.datasource.datasource.brewery.domain.model.Brewery

class BreweryListRepositoryImpl(
    private val breweryListDataSource: BreweryListDataSource,
    private val breweryListDatabaseProvider: BreweryListDatabaseProvider
) : BreweryListRepository {
    override suspend fun getBreweryList(): List<Brewery> =
        breweryListDataSource.getBreweryList()

    override suspend fun getDatabaseBreweryList(): List<Brewery> =
        breweryListDatabaseProvider.getBreweryList()

    override suspend fun insertBreweryList(breweryList: List<Brewery>) {
        breweryListDatabaseProvider.insertBreweryList(breweryList = breweryList)
    }
}
