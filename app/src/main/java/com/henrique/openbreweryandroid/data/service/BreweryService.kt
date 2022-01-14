package com.henrique.openbreweryandroid.data.service

import com.henrique.openbreweryandroid.domain.entity.BreweryEntity
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface BreweryService {

    @GET suspend fun getBreweryById(@Url id: String) : BreweryEntity?
    @GET suspend fun getBreweryList() : List<BreweryEntity>?
    @GET suspend fun searchBrewery(
        @Url search: String,
        @Query("query") query: String
    ) : List<BreweryEntity>?
}