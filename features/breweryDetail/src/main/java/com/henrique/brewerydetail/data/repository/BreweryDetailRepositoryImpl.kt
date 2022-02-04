package com.henrique.brewerydetail.data.repository

import com.henrique.brewerydetail.data.datasource.BreweryDetailDataSource
import com.henrique.shared.domain.model.Brewery
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
class BreweryDetailRepositoryImpl(private val breweryDetailDataSource: BreweryDetailDataSource) :
    KoinComponent, BreweryDetailRepository {

    override suspend fun getBreweryById(id: String): Brewery =
        breweryDetailDataSource.getBreweryById(id)
}