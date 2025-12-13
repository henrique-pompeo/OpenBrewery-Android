package com.henrique.datasource.datasource.brewerydetail.data.service

import com.henrique.datasource.datasource.brewerydetail.data.dto.BreweryDetailDTO
import retrofit2.http.GET
import retrofit2.http.Url

interface BreweryDetailService {
    @GET
    suspend fun getBreweryDetails(@Url id: String): BreweryDetailDTO
}