package com.henrique.brewerylist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.henrique.brewerylist.data.repository.BreweryListRepository
import com.henrique.brewerylist.ui.BreweryListViewModel
import com.henrique.shared.data.database.entities.BreweryEntity
import com.henrique.shared.data.remote.response.BreweryResponse
import com.henrique.shared.domain.model.Brewery
import io.mockk.clearAllMocks
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.component.KoinApiExtension
import org.koin.dsl.module
import org.koin.test.KoinTestRule

@RunWith(JUnit4::class)
@KoinApiExtension
@ExperimentalCoroutinesApi
abstract class UnitTest {

    private val testCoroutineDispatcher = TestCoroutineDispatcher()
    private val testCoroutineScope = TestCoroutineScope(testCoroutineDispatcher)

    @Rule @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(testCoroutineDispatcher)
        clearAllMocks()
    }

    @After
    fun tearDown() {
        testCoroutineScope.cleanupTestCoroutines()
        Dispatchers.resetMain()
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