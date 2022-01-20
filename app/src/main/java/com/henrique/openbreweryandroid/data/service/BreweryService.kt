package com.henrique.openbreweryandroid.data.service

import com.henrique.openbreweryandroid.data.response.BreweryResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface BreweryService {
    @GET suspend fun getBreweryById(@Url id: String) : BreweryResponse
    @GET suspend fun getBreweryList(@Url url: String) : List<BreweryResponse>
    @GET suspend fun searchBrewery(@Query("query") query: String) : List<BreweryResponse>
}