package com.henrique.data.repository

import com.henrique.data.source.remote.ApiService
import com.henrique.domain.model.Brewery
import com.henrique.domain.repositories.BreweriesRepository

class BreweriesRepositoryImpl(private val apiService: ApiService) : BreweriesRepository {

    override suspend fun getBreweries(): List<Brewery> {
        return apiService.getBreweries()
    }
}