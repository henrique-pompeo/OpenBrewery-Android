package com.henrique.openbrewery.domain.brewerylist.usecase

import com.henrique.datasource.datasource.brewerylist.domain.interfaces.repository.BreweryListRepository
import com.henrique.datasource.datasource.brewerylist.domain.model.Brewery
import com.henrique.openbrewery.domain.brewery.mappers.BreweryMapper
import com.henrique.openbrewery.domain.brewerylist.model.BreweryListState

class BreweryListUseCaseImpl(
    private val breweryMapper: BreweryMapper,
    private val breweryListRepository: BreweryListRepository
) : BreweryListUseCase {
    override suspend fun getBreweryList(): BreweryListState {
        var breweryListState: BreweryListState = BreweryListState.Error
        runCatching {
            val breweryList = breweryListRepository.getBreweryList()
            breweryListState = BreweryListState.Success(
                breweryMapper.toList(breweryList)
            )
            insertBreweryList(breweryList)
        }
        return breweryListState
    }

    private suspend fun insertBreweryList(breweryList: List<Brewery>) {
        runCatching {
            breweryListRepository.insertBreweryList(breweryList)
        }
    }

    override suspend fun getDatabaseBreweryList(): BreweryListState {
        var breweryListState: BreweryListState = BreweryListState.Error
        runCatching {
            val breweryList = breweryListRepository.getDatabaseBreweryList()
            breweryListState = BreweryListState.Success(
                breweryMapper.toList(breweryList)
            )
        }
        return breweryListState
    }
}
