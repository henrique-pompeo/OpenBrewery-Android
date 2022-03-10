package com.henrique.brewerydetail.data.repository

import com.henrique.brewerydetail.data.datasource.local.BreweryDetailLocalDataSource
import com.henrique.brewerydetail.data.datasource.remote.BreweryDetailDataSource
import com.henrique.shared.data.ResultStatus
import com.henrique.shared.data.extensions.model
import com.henrique.shared.domain.model.Brewery
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
            ResultStatus.Success(brewery.model())
        } catch (e: Exception) {
            when (e)  {
                is IOException, is SocketException, is HttpException ->
                    try {
                        val brewery = breweryDetailLocalDataSource.getBreweryById(id)
                        ResultStatus.Success(brewery.model())
                    } catch (localEx: Exception) {
                        ResultStatus.Error(localEx)
                    }
                else -> ResultStatus.Error(e)
            }
        }
}