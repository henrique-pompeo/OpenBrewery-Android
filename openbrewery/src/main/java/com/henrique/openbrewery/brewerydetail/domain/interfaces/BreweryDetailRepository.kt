package com.henrique.openbrewery.brewerydetail.domain.interfaces

import com.henrique.openbrewery.brewerydetail.data.dto.BreweryDetailDTO

internal interface BreweryDetailRepository {
    suspend fun getBreweryDetails(obdbId: String): BreweryDetailDTO
}
