package com.henrique.datasource.brewerylist.data.repository

import com.henrique.datasource.brewerylist.domain.interfaces.datasource.BreweryListLocalDataSource
import com.henrique.datasource.brewerylist.domain.interfaces.datasource.BreweryListDataSource
import com.henrique.datasource.data.ResultStatus
import com.henrique.datasource.data.database.entity.BreweryEntity
import com.henrique.datasource.data.extensions.model
import com.henrique.datasource.data.extensions.toEntity
import com.henrique.datasource.domain.model.Brewery
import com.henrique.datasource.brewerylist.domain.interfaces.repository.BreweryListRepository
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.net.SocketException

@KoinApiExtension
class BreweryListRepositoryImpl(
    private val breweryListDataSource: BreweryListDataSource,
    private val breweryListLocalDataSource: BreweryListLocalDataSource
) :
    KoinComponent, BreweryListRepository {

    override suspend fun getBreweryList(): ResultStatus<List<Brewery>> =
        try {
            val breweryList = breweryListDataSource.getBreweryList()
            if (breweryList.isNotEmpty()) {
                insertBreweryList(breweryList = breweryList.map { it.toEntity() })
                ResultStatus.Success(breweryList.map { it.model() })
            } else ResultStatus.Error("No data available")
        } catch (e: Exception) {
            when (e)  {
                is IOException, is SocketException, is HttpException ->
                    try {
                        val breweryList = breweryListLocalDataSource.getBreweryList()
                        if (breweryList.isNotEmpty())
                            ResultStatus.Success(breweryList.map { it.model() })
                        else ResultStatus.Error("No data available")
                    } catch (localEx: Exception) {
                        ResultStatus.Error(localEx.message)
                    }
                else -> ResultStatus.Error(e.message)
            }
        }

    override suspend fun insertBreweryList(breweryList: List<BreweryEntity>) {
        breweryListLocalDataSource.insertBreweryList(breweryList = breweryList)
    }
}