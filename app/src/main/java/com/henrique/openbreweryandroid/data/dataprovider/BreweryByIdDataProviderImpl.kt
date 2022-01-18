package com.henrique.openbreweryandroid.data.dataprovider

import com.henrique.openbreweryandroid.data.base.BaseDataProvider
import com.henrique.openbreweryandroid.data.repository.BreweryRepository
import com.henrique.openbreweryandroid.domain.entity.BreweryEntity
import com.henrique.openbreweryandroid.domain.dataprovider.BreweryByIdDataProvider
import org.koin.core.component.KoinApiExtension
import java.lang.Exception

@KoinApiExtension
class BreweryByIdDataProviderImpl(private val repository: BreweryRepository) :
    BaseDataProvider(), BreweryByIdDataProvider {
    override suspend fun searchBreweryById(id: String): BreweryEntity {
        val brewery = repository.getBreweryById(id)

        if (brewery != null)
            return brewery

        throw Exception()
    }
}