package com.henrique.openbrewery.brewerydetail.domain.usecase

import com.henrique.openbrewery.brewerydetail.data.mapper.BreweryDetailMapper
import com.henrique.openbrewery.brewerydetail.domain.interfaces.BreweryDetailRepository
import com.henrique.openbrewery.brewerydetail.domain.model.BreweryDetailModel

internal class BreweryDetailUseCaseImpl(
    private val breweryDetailRepository: BreweryDetailRepository
): BreweryDetailUseCase {

    override suspend fun getBreweryDetails(obdbId: String): BreweryDetailModel {
        val breweryDetail = breweryDetailRepository.getBreweryDetails(obdbId = obdbId)
        return BreweryDetailMapper.toDomain(breweryDetail)
    }
}
