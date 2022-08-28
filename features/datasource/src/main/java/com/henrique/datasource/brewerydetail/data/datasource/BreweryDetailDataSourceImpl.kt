package com.henrique.datasource.brewerydetail.data.datasource

import com.henrique.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDataSource
import com.henrique.datasource.brewerydetail.domain.interfaces.service.BreweryDetailService
import com.henrique.datasource.data.remote.response.BreweryResponse
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class BreweryDetailDataSourceImpl(private val breweryDetailService: BreweryDetailService) :
    KoinComponent, BreweryDetailDataSource {

    override suspend fun getBreweryById(id: String): BreweryResponse? = coroutineScope {
        breweryDetailService.getBreweryById(id)
    }
}