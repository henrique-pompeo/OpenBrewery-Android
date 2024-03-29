package com.henrique.datasource.datasource.brewerylist.data.service

import com.henrique.datasource.datasource.brewery.data.dto.BreweryDTO
import retrofit2.http.GET
import retrofit2.http.Url

interface BreweryListService {
    @GET
    suspend fun getBreweryList(@Url url: String) : List<BreweryDTO>
}