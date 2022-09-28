package com.henrique.datasource.datasource.brewerylist.data.datasource

import com.henrique.datasource.dataprovider.providers.database.openbrewery.dao.BreweryDao
import com.henrique.datasource.datasource.brewerylist.domain.interfaces.datasource.BreweryListDatabaseProvider
import com.henrique.datasource.datasource.brewery.data.mappers.BreweryMapper
import com.henrique.datasource.datasource.brewery.domain.model.Brewery

class BreweryListDatabaseProviderImpl(
    private val breweryDao: BreweryDao,
    private val breweryMapper: BreweryMapper
) : BreweryListDatabaseProvider {
    override suspend fun getBreweryList(): List<Brewery> {
        return breweryMapper.toListEntity(
            breweryDao.getBreweryList()
        )
    }

    override suspend fun insertBreweryList(breweryList: List<Brewery>) {
        breweryDao.insertBreweryList(
            breweryList = breweryMapper.toListDatabase(breweryList)
        )
    }
}