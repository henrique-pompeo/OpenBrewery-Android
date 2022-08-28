package com.henrique.datasource.brewerydetail.data.repository

import com.henrique.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailLocalDataSource
import com.henrique.datasource.brewerydetail.domain.interfaces.datasource.BreweryDetailDataSource
import com.henrique.datasource.brewerydetail.domain.interfaces.repository.BreweryDetailRepository
import com.henrique.datasource.data.ResultStatus
import com.henrique.datasource.data.extensions.model
import com.henrique.datasource.domain.model.Brewery
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.net.SocketException

@KoinApiExtension
class BreweryDetailRepositoryImpl
    (private val breweryDetailDataSource: BreweryDetailDataSource,
     private val breweryDetailLocalDataSource: BreweryDetailLocalDataSource
) :
    KoinComponent, BreweryDetailRepository {

    override suspend fun getBreweryById(id: String): ResultStatus<Brewery> =
        try {
            val brewery = breweryDetailDataSource.getBreweryById(id)
            result(brewery  = brewery?.model())
        } catch (e: Exception) {
            when (e)  {
                is IOException, is SocketException, is HttpException ->
                    try {
                        val brewery = breweryDetailLocalDataSource.getBreweryById(id)
                        result(brewery  = brewery?.model())
                    } catch (localEx: Exception) {
                        ResultStatus.Error(localEx.message)
                    }
                else -> ResultStatus.Error(e.message)
            }
        }

    private fun result (brewery: Brewery?) =
        if (brewery != null)
            ResultStatus.Success(brewery)
        else ResultStatus.Error("No data available")
}