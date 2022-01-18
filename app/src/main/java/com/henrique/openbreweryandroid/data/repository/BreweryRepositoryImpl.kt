package com.henrique.openbreweryandroid.data.repository

import com.henrique.openbreweryandroid.BuildConfig
import com.henrique.openbreweryandroid.data.service.BreweryService
import com.henrique.openbreweryandroid.domain.entity.BreweryEntity
import kotlinx.coroutines.coroutineScope
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.HttpException
import retrofit2.Retrofit

@KoinApiExtension
class BreweryRepositoryImpl : KoinComponent, BreweryRepository {

    private val retrofit: Retrofit by inject()
    private val breweryService: BreweryService = retrofit.create(BreweryService::class.java)

    override suspend fun getBreweryById(id: String): BreweryEntity? = coroutineScope {
        try {
            breweryService.getBreweryById(id)
        } catch (e: HttpException) {
            null
        }
    }

    override suspend fun getBreweryList(): List<BreweryEntity>? = coroutineScope {
        try {
            breweryService.getBreweryList("")
        } catch (e: HttpException) {
            null
        }
    }

    override suspend fun searchBrewery(search: String, query: String): List<BreweryEntity>? =
        coroutineScope {
            try {
                breweryService.searchBrewery(search, query)
            } catch (e: HttpException) {
                null
            }
        }
}