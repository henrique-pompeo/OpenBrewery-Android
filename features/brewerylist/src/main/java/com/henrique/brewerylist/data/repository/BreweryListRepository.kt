package com.henrique.brewerylist.data.repository

import com.henrique.shared.domain.model.Brewery

interface BreweryListRepository {
    suspend fun getBreweryList() : List<Brewery>
}