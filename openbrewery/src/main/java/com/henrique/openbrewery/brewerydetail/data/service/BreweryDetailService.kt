package com.henrique.openbrewery.brewerydetail.data.service

import com.henrique.openbrewery.brewerydetail.data.dto.BreweryDetailDTO
import retrofit2.http.GET
import retrofit2.http.Url

internal interface BreweryDetailService {

    @GET
    suspend fun getBreweryDetails(@Url obdbId: String): BreweryDetailDTO
}
