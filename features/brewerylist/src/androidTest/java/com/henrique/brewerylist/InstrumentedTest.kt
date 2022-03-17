package com.henrique.brewerylist

import android.content.Context
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import com.henrique.brewerylist.databinding.BreweryListItemBinding
import com.henrique.brewerylist.ui.adapter.BreweryListAdapter
import com.henrique.brewerylist.ui.viewholder.BreweryListViewHolderTest
import com.henrique.shared.data.database.entity.BreweryEntity
import com.henrique.shared.data.remote.response.BreweryResponse
import com.henrique.shared.domain.model.Brewery
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
abstract class InstrumentedTest {

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

        val context: Context = ApplicationProvider.getApplicationContext()
        val layout = RecyclerView(context).apply {
            layoutManager = LinearLayoutManager(context)
        }
        val list = listOf(brewery)
        val navController = NavController(context)
        val adapter = BreweryListAdapter(list, navController)
        val itemBinding = BreweryListItemBinding.inflate(
            LayoutInflater.from(context), layout, false
        )
    }
}
