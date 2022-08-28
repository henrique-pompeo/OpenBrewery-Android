package com.henrique.datasource.brewerylist.data.datasource

import com.henrique.datasource.data.database.dao.BreweryDao
import com.henrique.datasource.data.database.entity.BreweryEntity
import com.henrique.datasource.brewerylist.domain.interfaces.datasource.BreweryListLocalDataSource
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class BreweryListLocalDataSourceImpl(private val breweryDao: BreweryDao) : KoinComponent,
    BreweryListLocalDataSource {
    override suspend fun getBreweryList(): List<BreweryEntity> = coroutineScope {
        breweryDao.getBreweryList()
    }

    override suspend fun insertBreweryList(breweryList: List<BreweryEntity>) = coroutineScope {
        breweryDao.insertBreweryList(breweryList = breweryList)
    }
}