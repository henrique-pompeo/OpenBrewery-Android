package com.henrique.openbrewery.domain.brewerylist.usecase

import com.henrique.openbrewery.domain.brewerylist.model.BreweryListState

interface BreweryListUseCase {
    suspend fun getBreweryList() : BreweryListState
    suspend fun getDatabaseBreweryList() : BreweryListState
}