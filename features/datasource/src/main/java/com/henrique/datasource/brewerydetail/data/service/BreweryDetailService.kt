package com.henrique.datasource.brewerydetail.data.service

import com.henrique.datasource.data.remote.response.BreweryResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface BreweryDetailService {
    @GET
    suspend fun getBreweryById(@Url id: String) : BreweryResponse?
}