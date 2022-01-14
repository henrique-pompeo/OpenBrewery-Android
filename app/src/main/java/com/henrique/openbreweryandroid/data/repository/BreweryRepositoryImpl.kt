package com.henrique.openbreweryandroid.data.repository

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
    val service: BreweryRepository = retrofit.create(BreweryRepository::class.java)

    override suspend fun getBreweryById(id: String): BreweryEntity? = coroutineScope {
        try {
            service.getBreweryById(id)
        } catch (e: HttpException) {
            null
        }
    }

    override suspend fun getBreweryList(): List<BreweryEntity>? = coroutineScope {
        try {
            service.getBreweryList()
        } catch (e: HttpException) {
            null
        }
    }

    override suspend fun searchBrewery(query: String): List<BreweryEntity>? = coroutineScope {
        try {
            service.searchBrewery(query)
        } catch (e: HttpException) {
            null
        }
    }
}