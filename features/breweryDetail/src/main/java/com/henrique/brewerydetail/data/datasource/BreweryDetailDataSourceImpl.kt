package com.henrique.brewerydetail.data.datasource

import com.henrique.brewerydetail.data.service.BreweryDetailService
import com.henrique.shared.data.response.model
import com.henrique.shared.domain.model.Brewery
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class BreweryDetailDataSourceImpl(private val breweryDetailService: BreweryDetailService) :
    KoinComponent, BreweryDetailDataSource {

    override suspend fun getBreweryById(id: String): Brewery = coroutineScope {
        breweryDetailService.getBreweryById(id)
    }.model()
}