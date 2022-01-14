package com.henrique.openbreweryandroid.data.repository

import com.henrique.openbreweryandroid.data.service.BreweryService
import com.henrique.openbreweryandroid.domain.entity.BreweryEntity
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import retrofit2.HttpException

@KoinApiExtension
class BreweryRepositoryImpl(private val breweryService: BreweryService) :
    KoinComponent, BreweryRepository {

    override suspend fun getBreweryById(id: String): BreweryEntity? = coroutineScope {
        try {
            breweryService.getBreweryById(id)
        } catch (e: HttpException) {
            null
        }
    }

    override suspend fun getBreweryList(): List<BreweryEntity>? = coroutineScope {
        try {
            breweryService.getBreweryList()
        } catch (e: HttpException) {
            null
        }
    }

    override suspend fun searchBrewery(search: String, query: String): List<BreweryEntity>? = coroutineScope {
        try {
            breweryService.searchBrewery(search, query)
        } catch (e: HttpException) {
            null
        }
    }
}