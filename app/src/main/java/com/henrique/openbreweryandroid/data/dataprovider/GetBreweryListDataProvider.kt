package com.henrique.openbreweryandroid.data.dataprovider

import com.henrique.openbreweryandroid.data.repository.BreweryRepository
import com.henrique.openbreweryandroid.domain.entity.BreweryEntity
import com.henrique.openbreweryandroid.domain.gateway.GetBreweryListGateway

class GetBreweryListDataProvider(private val repository: BreweryRepository) :
    GetBreweryListGateway {

    override suspend fun getBreweryList(): List<BreweryEntity> {
        val breweryList = repository.getBreweryList()

        if (!breweryList.isNullOrEmpty())
            return breweryList

        throw Exception()
    }
}