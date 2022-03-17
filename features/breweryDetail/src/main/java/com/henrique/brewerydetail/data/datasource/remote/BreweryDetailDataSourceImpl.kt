package com.henrique.brewerydetail.data.datasource.remote

import com.henrique.brewerydetail.data.service.BreweryDetailService
import com.henrique.shared.data.remote.response.BreweryResponse
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