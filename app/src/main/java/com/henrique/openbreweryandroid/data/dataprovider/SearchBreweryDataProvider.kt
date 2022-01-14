package com.henrique.openbreweryandroid.data.dataprovider

import com.henrique.openbreweryandroid.data.repository.BreweryRepository
import com.henrique.openbreweryandroid.domain.entity.BreweryEntity
import com.henrique.openbreweryandroid.domain.gateway.SearchBreweryGateway
import java.lang.Exception

class SearchBreweryDataProvider (private val repository: BreweryRepository) :
    SearchBreweryGateway {
    override suspend fun searchBrewery(query: String): List<BreweryEntity> {
        val breweryList = repository.searchBrewery(query)

        if (!breweryList.isNullOrEmpty())
            return breweryList

        throw Exception()
    }
}