package com.henrique.openbrewery.brewerylist.data.repository

import com.henrique.openbrewery.brewerylist.data.dto.BreweryListItemDTO
import com.henrique.openbrewery.brewerylist.data.service.BreweryListService
import com.henrique.openbrewery.brewerylist.domain.interfaces.repository.BreweryListRepository

internal class BreweryListRepositoryImpl(
    private val breweryListService: BreweryListService,
): BreweryListRepository {

    override suspend fun getBreweryList(): List<BreweryListItemDTO> =
        breweryListService.getBreweryList()
}
