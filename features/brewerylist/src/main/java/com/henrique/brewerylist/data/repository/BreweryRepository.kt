package com.henrique.brewerylist.data.repository

import com.henrique.brewerylist.domain.model.Brewery

interface BreweryRepository {
    suspend fun getBreweryById(id: String) : Brewery
    suspend fun getBreweryList() : List<Brewery>
    suspend fun searchBrewery(query: String) : List<Brewery>
}