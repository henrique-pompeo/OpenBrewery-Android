package com.henrique.datasource.brewerylist.domain.interfaces.service

import com.henrique.datasource.data.remote.response.BreweryResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface BreweryListService {
    @GET
    suspend fun getBreweryList(@Url url: String) : List<BreweryResponse>
}