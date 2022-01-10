package com.henrique.data.source.remote

import com.henrique.domain.model.Brewery
import retrofit2.http.GET

interface ApiService {

    @GET("/breweries")
    suspend fun getBreweries(): List<Brewery>
}