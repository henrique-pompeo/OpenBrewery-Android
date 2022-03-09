package com.henrique.brewerylist.data.datasource.local

import com.henrique.shared.data.database.dao.BreweryDao
import com.henrique.shared.data.database.entities.BreweryEntity
import com.henrique.shared.data.database.entities.model
import com.henrique.shared.domain.model.Brewery
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class BreweryListLocalDataSourceImpl(private val breweryDao: BreweryDao) : KoinComponent, BreweryListLocalDataSource {
    override suspend fun getBreweryList(): List<BreweryEntity> = coroutineScope {
        breweryDao.getBreweryList()
    }

    override suspend fun insertBrewery(brewery: BreweryEntity) {
        breweryDao.insertBrewery(brewery = brewery)
    }

    override suspend fun insertBreweryList(breweryList: List<BreweryEntity>) = coroutineScope {
        breweryDao.insertBreweryList(breweryList = breweryList)
    }

    override suspend fun updateBrewery(brewery: BreweryEntity) {
        breweryDao.updateBrewery(brewery)
    }

    override suspend fun deleteBrewery(breweryEntity: BreweryEntity) = coroutineScope {
        breweryDao.deleteBrewery(breweryEntity)
    }
}