package com.henrique.openbrewery.brewerydetail.domain.usecase

import com.henrique.openbrewery.brewerydetail.domain.model.BreweryDetailModel


internal interface BreweryDetailUseCase {
    suspend fun getBreweryDetails(obdbId: String): BreweryDetailModel
}
