package com.henrique.openbreweryandroid.data.dataprovider

import com.henrique.openbreweryandroid.data.repository.BreweryRepository
import com.henrique.openbreweryandroid.domain.entity.BreweryEntity
import com.henrique.openbreweryandroid.domain.gateway.GetBreweryByIdGateway
import java.lang.Exception

class GetBreweryByIdDataProvider(private val repository: BreweryRepository) :
    GetBreweryByIdGateway {
    override suspend fun searchBreweryById(id: String): BreweryEntity {
        val brewery = repository.getBreweryById(id)

        if (brewery != null)
            return brewery

        throw Exception()
    }
}