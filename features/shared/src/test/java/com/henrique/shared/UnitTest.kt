package com.henrique.shared

import com.henrique.shared.data.database.entity.BreweryEntity
import com.henrique.shared.data.remote.response.BreweryResponse
import com.henrique.shared.domain.model.Brewery

abstract class UnitTest {

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

        val brewery = Brewery(
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
