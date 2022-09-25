package com.henrique.datasource

import androidx.test.core.app.ApplicationProvider
import com.henrique.datasource.dataprovider.providers.database.openbrewery.entity.BreweryEntity
import com.henrique.datasource.data.remote.response.BreweryResponse
import com.henrique.datasource.dataprovider.providers.infrastructure.DataProvidersDI
import com.henrique.datasource.infrastructure.DatasourceDI
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail
import org.junit.Before
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinApiExtension
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

@KoinApiExtension
abstract class InstrumentedTest {

    open fun onSetUp() {}

    open fun onTearDown() {}

    @Before
    fun setUp() {
        stopKoin()
        startKoin {
            androidContext(ApplicationProvider.getApplicationContext())
            modules(
                module {
                    DatasourceDI.module +
                            DataProvidersDI.module
                }
            )
        }
        onSetUp()
    }

    companion object {

        val breweryResponse = BreweryResponse(
            id = "id",
            name = "name",
            breweryType = "breweryType",
            street = "street",
            address2 = "address2",
            address3 = "address3",
            city = "city",
            state = "state",
            countyProvince = "countyProvince",
            postalCode = "postalCode",
            country = "country",
            longitude = "longitude",
            latitude = "latitude",
            phone = "phone",
            websiteUrl = "websiteUrl",
            updatedAt = "2021-10-23T02:24:55.243Z",
            createdAt = "2021-10-23T02:24:55.243Z"
        )

        val breweryEntity = BreweryEntity(
            id = "id",
            name = "name",
            breweryType = "breweryType",
            street = "street",
            address2 = "address2",
            address3 = "address3",
            city = "city",
            state = "state",
            countyProvince = "countyProvince",
            postalCode = "postalCode",
            country = "country",
            longitude = "longitude",
            latitude = "latitude",
            phone = "phone",
            websiteUrl = "websiteUrl",
            updatedAt = "2021-10-23T02:24:55.243Z",
            createdAt = "2021-10-23T02:24:55.243Z"
        )

        val brewery = BreweryDetail(
            id = "id",
            name = "name",
            breweryType = "breweryType",
            street = "street",
            address2 = "address2",
            address3 = "address3",
            city = "city",
            state = "state",
            countyProvince = "countyProvince",
            postalCode = "postalCode",
            country = "country",
            longitude = "longitude",
            latitude = "latitude",
            phone = "phone",
            websiteUrl = "websiteUrl",
            updatedAt = "2021-10-23T02:24:55.243Z",
            createdAt = "2021-10-23T02:24:55.243Z"
        )
    }
}
