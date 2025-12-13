package com.henrique.openbrewery.brewerylist.domain.usecase

import com.henrique.openbrewery.brewerylist.domain.model.BreweryListItemModel

internal interface BreweryListUseCase {
    suspend fun getBreweryList(): List<BreweryListItemModel>
}
