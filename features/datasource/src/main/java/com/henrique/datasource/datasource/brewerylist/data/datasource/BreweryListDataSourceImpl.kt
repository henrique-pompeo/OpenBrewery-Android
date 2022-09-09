package com.henrique.datasource.datasource.brewerylist.data.datasource

import com.henrique.datasource.datasource.brewerylist.data.service.BreweryListService
import com.henrique.datasource.datasource.brewerylist.domain.interfaces.datasource.BreweryListDataSource
import com.henrique.datasource.datasource.brewerylist.data.mappers.BreweryMapper
import com.henrique.datasource.datasource.brewerylist.domain.model.Brewery

class BreweryListDataSourceImpl(
    private val breweryListService: BreweryListService,
    private val breweryMapper: BreweryMapper
) : BreweryListDataSource {
    override suspend fun getBreweryList(): List<Brewery> {
        return breweryMapper.toList(
            breweryListService.getBreweryList("")
        )
    }
}
