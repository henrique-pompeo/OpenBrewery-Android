package com.henrique.datasource.brewerylist.data.service

import com.henrique.datasource.brewerylist.domain.model.BreweryDTO
import retrofit2.http.GET
import retrofit2.http.Url

interface BreweryListService {
    @GET
    suspend fun getBreweryList(@Url url: String) : List<BreweryDTO>
}