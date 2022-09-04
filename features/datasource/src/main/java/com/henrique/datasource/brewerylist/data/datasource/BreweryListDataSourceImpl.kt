package com.henrique.datasource.brewerylist.data.datasource

import com.henrique.datasource.brewerylist.data.service.BreweryListService
import com.henrique.datasource.data.remote.response.BreweryResponse
import com.henrique.datasource.brewerylist.domain.interfaces.datasource.BreweryListDataSource
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class BreweryListDataSourceImpl(private val breweryListService: BreweryListService) : KoinComponent,
    BreweryListDataSource {

    override suspend fun getBreweryList(): List<BreweryResponse> = coroutineScope {
        breweryListService.getBreweryList("")
    }
}