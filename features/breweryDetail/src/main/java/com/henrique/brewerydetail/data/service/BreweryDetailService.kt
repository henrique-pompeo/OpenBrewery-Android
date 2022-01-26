package com.henrique.brewerydetail.data.service

import com.henrique.featurecommons.data.response.BreweryResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface BreweryDetailService {
    @GET
    suspend fun getBreweryById(@Url id: String) : BreweryResponse
}