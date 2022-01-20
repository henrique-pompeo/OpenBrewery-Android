package com.henrique.openbreweryandroid.data.repository

import com.henrique.openbreweryandroid.domain.model.Brewery
import com.henrique.openbreweryandroid.domain.base.Error
import com.henrique.openbreweryandroid.domain.base.Result

interface BreweryRepository {
    suspend fun getBreweryById(id: String) : Brewery
    suspend fun getBreweryList() : List<Brewery>
    suspend fun searchBrewery(query: String) : List<Brewery>
}