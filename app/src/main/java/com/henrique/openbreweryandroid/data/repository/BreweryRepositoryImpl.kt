package com.henrique.openbreweryandroid.data.repository

import com.henrique.openbreweryandroid.data.response.Model
import com.henrique.openbreweryandroid.data.service.BreweryService
import com.henrique.openbreweryandroid.domain.model.Brewery
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class BreweryRepositoryImpl(private val breweryService: BreweryService) : KoinComponent, BreweryRepository {

    override suspend fun getBreweryById(id: String): Brewery = coroutineScope {
        breweryService.getBreweryById(id)
    }.Model()

    override suspend fun getBreweryList(): List<Brewery> = coroutineScope {
        breweryService.getBreweryList("")
    }.map { it.Model() }

    override suspend fun searchBrewery(query: String): List<Brewery> = coroutineScope {
        breweryService.searchBrewery(query)
    }.map { it.Model() }
}