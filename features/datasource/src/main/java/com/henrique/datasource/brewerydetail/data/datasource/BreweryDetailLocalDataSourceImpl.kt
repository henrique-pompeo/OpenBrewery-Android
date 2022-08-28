package com.henrique.datasource.brewerydetail.data.datasource

import com.henrique.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailLocalDataSource
import com.henrique.datasource.data.database.dao.BreweryDao
import com.henrique.datasource.data.database.entity.BreweryEntity
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class BreweryDetailLocalDataSourceImpl(private val breweryDao: BreweryDao) :
    KoinComponent, BreweryDetailLocalDataSource {

    override suspend fun getBreweryById(id: String): BreweryEntity? = coroutineScope {
        breweryDao.getBreweryById(id)
    }
}