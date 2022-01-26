package com.henrique.brewerydetail.data.repository

import com.henrique.brewerydetail.data.service.BreweryDetailService
import com.henrique.featurecommons.data.response.model
import com.henrique.featurecommons.domain.model.Brewery
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class BreweryDetailRepositoryImpl(private val breweryDetailService: BreweryDetailService) :
    KoinComponent, BreweryDetailRepository {

    override suspend fun getBreweryById(id: String): Brewery = coroutineScope {
        breweryDetailService.getBreweryById(id)
    }.model()

}