package com.henrique.datasource.datasource.brewerydetail.data.datasource

import com.henrique.datasource.datasource.brewerydetail.data.mappers.BreweryDetailMapper
import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDataSource
import com.henrique.datasource.datasource.brewerydetail.data.service.BreweryDetailService
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail

class BreweryDetailDataSourceImpl(
    private val breweryDetailService: BreweryDetailService,
    private val breweryDetailMapper: BreweryDetailMapper
) : BreweryDetailDataSource {
    override suspend fun getBreweryDetails(id: String): BreweryDetail {
        return breweryDetailMapper.toDomain(
            breweryDetailService.getBreweryDetails(id)
        )
    }
}
