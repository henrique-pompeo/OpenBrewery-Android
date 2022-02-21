package com.henrique.brewerydetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.henrique.brewerydetail.data.repository.BreweryDetailRepository
import com.henrique.brewerydetail.ui.BreweryDetailViewModel
import com.henrique.shared.data.response.BreweryResponse
import com.henrique.shared.domain.model.Brewery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule
import org.koin.core.component.KoinApiExtension
import org.koin.dsl.module
import org.koin.test.KoinTestRule

@KoinApiExtension
@ExperimentalCoroutinesApi
abstract class BreweryDetailTest {

    lateinit var breweryDetailViewModel: BreweryDetailViewModel

    var breweryDetailRepository = mockk<BreweryDetailRepository>()

    val testDispatcher =  TestCoroutineDispatcher()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(
            module {
                single { breweryDetailRepository }
            }
        )
    }

    @Before
    fun setup() {
        with(Dispatchers) { setMain(testDispatcher) }

        breweryDetailViewModel = BreweryDetailViewModel(
            breweryDetailRepository = breweryDetailRepository
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
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