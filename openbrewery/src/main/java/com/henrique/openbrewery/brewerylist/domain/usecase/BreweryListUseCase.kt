package com.henrique.openbrewery.brewerylist.domain.usecase

import com.henrique.openbrewery.brewerylist.domain.model.BreweryListState

interface BreweryListUseCase {
    suspend fun getBreweryList() : BreweryListState
    suspend fun getDatabaseBreweryList() : BreweryListState
}