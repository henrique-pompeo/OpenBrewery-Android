package com.henrique.openbrewery.brewerylist.domain.usecase

import com.henrique.openbrewery.brewerylist.data.mapper.BreweryListMapper
import com.henrique.openbrewery.brewerylist.domain.interfaces.repository.BreweryListRepository
import com.henrique.openbrewery.brewerylist.domain.model.BreweryListItemModel

internal class BreweryListUseCaseImpl(
    private val breweryListRepository: BreweryListRepository
): BreweryListUseCase {

    override suspend fun getBreweryList(): List<BreweryListItemModel> {
        val breweryList = breweryListRepository.getBreweryList()
        return BreweryListMapper.toList(breweryList)
    }
}
