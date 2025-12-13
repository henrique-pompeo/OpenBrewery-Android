package com.henrique.datasource.datasource.brewerydetail.data.repository

import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDatabaseProvider
import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDataSource
import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.repository.BreweryDetailRepository
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail

class BreweryDetailRepositoryImpl(
    private val breweryDetailDataSource: BreweryDetailDataSource,
    private val breweryDetailDatabaseProvider: BreweryDetailDatabaseProvider
): BreweryDetailRepository {
    override suspend fun getBreweryDetails(id: String): BreweryDetail =
        breweryDetailDataSource.getBreweryDetails(id)

    override suspend fun getDatabaseBreweryDetails(id: String): BreweryDetail =
        breweryDetailDatabaseProvider.getBreweryDetails(id)
}
