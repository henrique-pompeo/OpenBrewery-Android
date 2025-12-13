package com.henrique.openbrewery.brewerydetail.data.repository

import com.henrique.openbrewery.brewerydetail.data.dto.BreweryDetailDTO
import com.henrique.openbrewery.brewerydetail.data.service.BreweryDetailService
import com.henrique.openbrewery.brewerydetail.domain.interfaces.BreweryDetailRepository

internal class BreweryDetailRepositoryImpl(
    private val breweryDetailService: BreweryDetailService
): BreweryDetailRepository {

    override suspend fun getBreweryDetails(obdbId: String): BreweryDetailDTO =
        breweryDetailService.getBreweryDetails(obdbId = obdbId)
}
