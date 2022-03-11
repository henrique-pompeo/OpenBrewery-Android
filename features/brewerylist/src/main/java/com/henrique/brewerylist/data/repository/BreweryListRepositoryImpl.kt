package com.henrique.brewerylist.data.repository

import com.henrique.brewerylist.data.datasource.local.BreweryListLocalDataSource
import com.henrique.brewerylist.data.datasource.remote.BreweryListDataSource
import com.henrique.shared.data.ResultStatus
import com.henrique.shared.data.database.entities.BreweryEntity
import com.henrique.shared.data.extensions.model
import com.henrique.shared.data.extensions.toEntity
import com.henrique.shared.domain.model.Brewery
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.net.SocketException

@KoinApiExtension
class BreweryListRepositoryImpl(
    private val breweryListDataSource: BreweryListDataSource,
    private val breweryListLocalDataSource: BreweryListLocalDataSource) :
    KoinComponent, BreweryListRepository {

    override suspend fun getBreweryList(): ResultStatus<List<Brewery>> =
        try {
            val breweryList = breweryListDataSource.getBreweryList()
            insertBreweryList(breweryList = breweryList.map { it.toEntity() })
            ResultStatus.Success(breweryList.map { it.model() })
        } catch (e: Exception) {
            when (e)  {
                is IOException, is SocketException, is HttpException ->
                    try {
                        val breweryList = breweryListLocalDataSource.getBreweryList()
                        ResultStatus.Success(breweryList.map { it.model() })
                    } catch (localEx: Exception) {
                        ResultStatus.Error(localEx)
                    }
                else -> ResultStatus.Error(e)
            }
        }

    override suspend fun insertBreweryList(breweryList: List<BreweryEntity>) {
        breweryListLocalDataSource.insertBreweryList(breweryList = breweryList)
    }
}