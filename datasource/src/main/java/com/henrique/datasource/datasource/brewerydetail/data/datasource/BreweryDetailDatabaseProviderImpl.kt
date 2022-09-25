package com.henrique.datasource.datasource.brewerydetail.data.datasource

import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDatabaseProvider
import com.henrique.datasource.dataprovider.providers.database.openbrewery.dao.BreweryDao
import com.henrique.datasource.datasource.brewerydetail.data.mappers.BreweryDetailMapper
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail

class BreweryDetailDatabaseProviderImpl(
    private val breweryDao: BreweryDao,
    private val breweryDetailMapper: BreweryDetailMapper
) : BreweryDetailDatabaseProvider {
    override suspend fun getBreweryDetails(id: String): BreweryDetail {
        return breweryDetailMapper.toDomainEntity(
            breweryDao.getBreweryDetails(id)
        )
    }
}