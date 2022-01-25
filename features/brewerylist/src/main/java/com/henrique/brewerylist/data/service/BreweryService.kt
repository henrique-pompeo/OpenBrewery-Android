package com.henrique.brewerylist.data.service

import com.henrique.brewerylist.data.response.BreweryResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface BreweryService {
    @GET suspend fun getBreweryById(@Url id: String) : BreweryResponse
    @GET suspend fun getBreweryList(@Url url: String) : List<BreweryResponse>
    @GET suspend fun searchBrewery(@Query("query") query: String) : List<BreweryResponse>
}