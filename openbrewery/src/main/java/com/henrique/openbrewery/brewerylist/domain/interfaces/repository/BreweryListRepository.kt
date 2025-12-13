package com.henrique.openbrewery.brewerylist.domain.interfaces.repository

import com.henrique.openbrewery.brewerylist.data.dto.BreweryListItemDTO

internal interface BreweryListRepository {
    suspend fun getBreweryList(): List<BreweryListItemDTO>
}
