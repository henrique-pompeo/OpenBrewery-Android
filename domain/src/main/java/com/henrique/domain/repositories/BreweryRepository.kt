package com.henrique.domain.repositories

import com.henrique.domain.model.Brewery

interface BreweryRepository {
    fun getBreweries() : List<Brewery>
}