package com.henrique.openbreweryandroid.data.dataprovider

import com.henrique.openbreweryandroid.data.base.BaseDataProvider
import com.henrique.openbreweryandroid.data.repository.BreweryRepository
import com.henrique.openbreweryandroid.domain.entity.BreweryEntity
import com.henrique.openbreweryandroid.domain.dataprovider.BreweryListDataProvider
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class BreweryListDataProviderImpl(private val repository: BreweryRepository) :
    BaseDataProvider(), BreweryListDataProvider {

    override suspend fun getBreweryList(): List<BreweryEntity> {
        val breweryList = repository.getBreweryList()

        if (!breweryList.isNullOrEmpty())
            return breweryList

        throw Exception()
    }
}