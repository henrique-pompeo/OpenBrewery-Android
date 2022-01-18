package com.henrique.openbreweryandroid.data.dataprovider

import com.henrique.openbreweryandroid.data.base.BaseDataProvider
import com.henrique.openbreweryandroid.data.repository.BreweryRepository
import com.henrique.openbreweryandroid.domain.entity.BreweryEntity
import com.henrique.openbreweryandroid.domain.dataprovider.SearchBreweryDataProvider
import org.koin.core.component.KoinApiExtension
import java.lang.Exception

@KoinApiExtension
class SearchBreweryDataProviderImpl (private val repository: BreweryRepository) :
    BaseDataProvider(), SearchBreweryDataProvider {
    override suspend fun searchBrewery(search: String, query: String): List<BreweryEntity> {
        val breweryList = repository.searchBrewery(search, query)

        if (!breweryList.isNullOrEmpty())
            return breweryList

        throw Exception()
    }
}