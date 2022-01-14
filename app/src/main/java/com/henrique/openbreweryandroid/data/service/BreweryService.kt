package com.henrique.openbreweryandroid.data.service

import com.henrique.openbreweryandroid.domain.entity.BreweryEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface BreweryService {
    @GET("breweries/{id}")
    suspend fun getBreweryById(@Path("id") id: String) : BreweryEntity?

    @GET("breweries/")
    suspend fun getBreweryList() : List<BreweryEntity>?

    @GET("breweries/search?query={query}")
    suspend fun searchBrewery(@Path("query") query: String) : List<BreweryEntity>?
}