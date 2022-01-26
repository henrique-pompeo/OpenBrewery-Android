package com.henrique.brewerylist.data.repository

import com.henrique.brewerylist.data.service.BreweryService
import com.henrique.featurecommons.data.response.model
import com.henrique.featurecommons.domain.model.Brewery
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class BreweryRepositoryImpl(private val breweryService: BreweryService) : KoinComponent, BreweryRepository {

    override suspend fun getBreweryList(): List<Brewery> = coroutineScope {
        breweryService.getBreweryList("")
    }.map { it.model() }

}