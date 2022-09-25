package com.henrique.openbrewery.domain.brewerydetail.usecase

import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetailState


interface BreweryDetailUseCase {
    suspend fun getBreweryDetails(id: String) : BreweryDetailState
    suspend fun getDatabaseBreweryDetails(id: String) : BreweryDetailState
}