package com.henrique.openbrewery.brewerylist.data.datasource

import com.henrique.openbrewery.brewerylist.data.service.BreweryListService
import com.henrique.openbrewery.brewerylist.domain.interfaces.datasource.BreweryListDataSource
import com.henrique.datasource.datasource.brewery.data.mappers.BreweryMapper
import com.henrique.datasource.datasource.brewery.domain.model.Brewery

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
