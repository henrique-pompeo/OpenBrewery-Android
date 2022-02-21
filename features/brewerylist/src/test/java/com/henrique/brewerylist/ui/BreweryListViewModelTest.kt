package com.henrique.brewerylist.ui

import androidx.lifecycle.Observer
import com.henrique.brewerylist.BreweryListTest
import com.henrique.shared.data.Result
import com.henrique.shared.domain.model.Brewery
import io.kotlintest.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
@ExperimentalCoroutinesApi
class BreweryListViewModelTest : BreweryListTest() {

    private val breweryListObserver = mockk<Observer<Result<List<Brewery>>>>(relaxed = true)

    private val breweryListStates = mutableListOf<Result<List<Brewery>>>()

    @Test
    fun `SHOULD call getBreweryList() and THEN post success WHEN the call succeeds`() =
        runBlocking {

            coEvery { breweryListRepository.getBreweryList() } returns listOf(brewery)

            with(breweryListViewModel) {
                breweryList.observeForever(breweryListObserver)
                getBreweryList()
            }

            coVerify { breweryListRepository.getBreweryList() }

            verify { breweryListObserver.onChanged(capture(breweryListStates)) }

            breweryListStates shouldBe listOf(
                Result.Loading,
                Result.Success(listOf(brewery))
            )

            confirmVerified(breweryListRepository)
        }

    @Test
    fun `SHOULD Call getBreweryList() and THEN post error WHEN the call fails`() =
        runBlocking {

            val exception = Exception()

            coEvery { breweryListRepository.getBreweryList() } throws exception

            with(breweryListViewModel) {
                breweryList.observeForever(breweryListObserver)
                getBreweryList()
            }

            coVerify { breweryListRepository.getBreweryList() }

            verify { breweryListObserver.onChanged(capture(breweryListStates)) }

            breweryListStates shouldBe listOf(
                Result.Loading,
                Result.Error(exception)
            )

            confirmVerified(breweryListRepository)

        }
}