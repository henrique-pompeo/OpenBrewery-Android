package com.henrique.brewerylist.data.repository

import com.henrique.brewerylist.data.response.model
import com.henrique.brewerylist.data.service.BreweryService
import com.henrique.brewerylist.domain.model.Brewery
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class BreweryRepositoryImpl(private val breweryService: BreweryService) : KoinComponent, BreweryRepository {

    override suspend fun getBreweryById(id: String): Brewery = coroutineScope {
        breweryService.getBreweryById(id)
    }.model()

    override suspend fun getBreweryList(): List<Brewery> = coroutineScope {
        breweryService.getBreweryList("")
    }.map { it.model() }

    override suspend fun searchBrewery(query: String): List<Brewery> = coroutineScope {
        breweryService.searchBrewery(query)
    }.map { it.model() }
}