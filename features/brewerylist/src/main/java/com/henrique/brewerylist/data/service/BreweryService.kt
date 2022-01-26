package com.henrique.brewerylist.data.service

import com.henrique.featurecommons.data.response.BreweryResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface BreweryService {
    @GET
    suspend fun getBreweryList(@Url url: String) : List<BreweryResponse>
}