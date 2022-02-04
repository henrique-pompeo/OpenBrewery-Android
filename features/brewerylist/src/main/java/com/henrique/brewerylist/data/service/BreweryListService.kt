package com.henrique.brewerylist.data.service

import com.henrique.shared.data.response.BreweryResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface BreweryListService {
    @GET
    suspend fun getBreweryList(@Url url: String) : List<BreweryResponse>
}