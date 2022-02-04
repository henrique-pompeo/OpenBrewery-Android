package com.henrique.brewerylist.data.repository

import com.henrique.brewerylist.data.datasource.BreweryListDataSource
import com.henrique.shared.domain.model.Brewery
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class BreweryListRepositoryImpl(private val breweryListDataSource: BreweryListDataSource) :
    KoinComponent, BreweryListRepository {

    override suspend fun getBreweryList(): List<Brewery> = breweryListDataSource.getBreweryList()
}