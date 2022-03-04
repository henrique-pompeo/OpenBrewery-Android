package com.henrique.brewerylist.data.repository

import com.henrique.brewerylist.data.datasource.local.BreweryListLocalDataSource
import com.henrique.brewerylist.data.datasource.remote.BreweryListDataSource
import com.henrique.shared.data.database.entities.BreweryEntity
import com.henrique.shared.domain.model.Brewery
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class BreweryListRepositoryImpl(
    private val breweryListDataSource: BreweryListDataSource,
    private val breweryListLocalDataSource: BreweryListLocalDataSource) :
    KoinComponent, BreweryListRepository {

    override suspend fun getBreweryList(): List<Brewery> = breweryListDataSource.getBreweryList()

    override suspend fun getBreweryListLocal(): List<Brewery> =
        breweryListLocalDataSource.getBreweryList()

    override suspend fun insertBrewery(breweryEntity: BreweryEntity) {
        breweryListLocalDataSource.insertBrewery(breweryEntity = breweryEntity)
    }

    override suspend fun updateBrewery(brewery: BreweryEntity) {
        breweryListLocalDataSource.updateBrewery(brewery)
    }

    override suspend fun deleteBrewery(breweryEntity: BreweryEntity) {
        breweryListLocalDataSource.deleteBrewery(breweryEntity = breweryEntity)
    }
}