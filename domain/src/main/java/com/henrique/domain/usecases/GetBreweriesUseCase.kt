package com.henrique.domain.usecases


import com.henrique.domain.model.Brewery
import com.henrique.domain.repositories.BreweriesRepository
import com.henrique.domain.usecases.base.UseCase


class GetBreweriesUseCase constructor(
    private val breweriesRepository: BreweriesRepository
) : UseCase<List<Brewery>, Any?>() {
    override suspend fun run(params: Any?): List<Brewery> {
        return breweriesRepository.getBreweries()
    }
}