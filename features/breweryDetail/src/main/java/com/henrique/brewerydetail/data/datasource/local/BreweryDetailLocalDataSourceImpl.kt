package com.henrique.brewerydetail.data.datasource.local

import com.henrique.shared.data.database.dao.BreweryDao
import com.henrique.shared.data.database.entities.BreweryEntity
import com.henrique.shared.data.database.entities.model
import com.henrique.shared.data.remote.response.BreweryResponse
import com.henrique.shared.domain.model.Brewery
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class BreweryDetailLocalDataSourceImpl(private val breweryDao: BreweryDao) :
    KoinComponent, BreweryDetailLocalDataSource {

    override suspend fun getBreweryById(id: String): BreweryEntity = coroutineScope {
        breweryDao.getLocalBreweryById(id)
    }
}