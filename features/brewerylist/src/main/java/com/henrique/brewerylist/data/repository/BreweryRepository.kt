package com.henrique.brewerylist.data.repository

import com.henrique.featurecommons.domain.model.Brewery

interface BreweryRepository {
    suspend fun getBreweryList() : List<Brewery>
}