package com.henrique.domain.repositories

import com.henrique.domain.model.Brewery

interface BreweriesRepository {
    suspend fun getBreweries() : List<Brewery>
}