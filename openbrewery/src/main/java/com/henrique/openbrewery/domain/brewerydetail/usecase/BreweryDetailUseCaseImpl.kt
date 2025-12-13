package com.henrique.openbrewery.domain.brewerydetail.usecase

import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.repository.BreweryDetailRepository
import com.henrique.openbrewery.domain.brewerydetail.mappers.BreweryDetailMapper
import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetailState

class BreweryDetailUseCaseImpl(
    private val breweryDetailMapper: BreweryDetailMapper,
    private val breweryDetailRepository: BreweryDetailRepository
): BreweryDetailUseCase {
    override suspend fun getBreweryDetails(id: String): BreweryDetailState {
        var breweryDetailState: BreweryDetailState = BreweryDetailState.Error
        runCatching {
            val breweryDetail = breweryDetailRepository.getBreweryDetails(id = id)
            breweryDetailState = BreweryDetailState.Success(
                breweryDetailMapper.toDomain(breweryDetail)
            )
        }
        return breweryDetailState
    }

    override suspend fun getDatabaseBreweryDetails(id: String): BreweryDetailState {
        var breweryDetailState: BreweryDetailState = BreweryDetailState.Error
        runCatching {
            val breweryDetail = breweryDetailRepository.getDatabaseBreweryDetails(id = id)
            breweryDetailState = BreweryDetailState.Success(
                breweryDetailMapper.toDomain(breweryDetail)
            )
        }
        return breweryDetailState
    }
}
