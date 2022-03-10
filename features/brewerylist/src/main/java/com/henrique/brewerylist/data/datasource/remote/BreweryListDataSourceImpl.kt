package com.henrique.brewerylist.data.datasource.remote

import com.henrique.brewerylist.data.service.BreweryListService
import com.henrique.shared.data.remote.response.BreweryResponse
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