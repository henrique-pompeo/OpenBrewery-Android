package com.henrique.datasource.brewerydetail.domain.interfaces.repository

import com.henrique.datasource.data.ResultStatus
import com.henrique.datasource.domain.model.Brewery

interface BreweryDetailRepository {
    suspend fun getBreweryById(id: String) : ResultStatus<Brewery>
}