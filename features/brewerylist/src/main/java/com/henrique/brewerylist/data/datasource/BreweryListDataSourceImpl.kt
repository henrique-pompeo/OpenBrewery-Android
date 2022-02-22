package com.henrique.brewerylist.data.datasource

import com.henrique.brewerylist.data.service.remote.BreweryListService
import com.henrique.shared.data.remote.response.model
import com.henrique.shared.domain.model.Brewery
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class BreweryListDataSourceImpl(private val breweryListService: BreweryListService) : KoinComponent,
    BreweryListDataSource {

    override suspend fun getBreweryList(): List<Brewery> = coroutineScope {
        breweryListService.getBreweryList("")
    }.map { it.model() }
}