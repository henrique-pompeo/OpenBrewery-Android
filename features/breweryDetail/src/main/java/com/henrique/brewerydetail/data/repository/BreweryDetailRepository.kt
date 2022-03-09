package com.henrique.brewerydetail.data.repository

import com.henrique.shared.data.ResultStatus
import com.henrique.shared.domain.model.Brewery

interface BreweryDetailRepository {
    suspend fun getBreweryById(id: String) : ResultStatus<Brewery>
}