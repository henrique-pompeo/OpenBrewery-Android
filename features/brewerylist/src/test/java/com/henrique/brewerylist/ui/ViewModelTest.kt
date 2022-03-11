package com.henrique.brewerylist.ui

import androidx.lifecycle.Observer
import com.henrique.brewerylist.UnitTest
import com.henrique.shared.data.ResultStatus
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
class ViewModelTest : UnitTest() {

    private val breweryListObserver = mockk<Observer<ResultStatus<List<Brewery>>>>(relaxed = true)

    private val breweryListStates = mutableListOf<ResultStatus<List<Brewery>>>()

    @Test
    fun `SHOULD call getBreweryList() and THEN post success WHEN the call succeeds`() =
        runBlocking {

            coEvery { breweryListRepository.getBreweryList() } returns
                    ResultStatus.Success(listOf(brewery))

            with(breweryListViewModel) {
                breweryListLiveData.observeForever(breweryListObserver)
                getBreweryList()
            }

            coVerify { breweryListRepository.getBreweryList() }

            verify { breweryListObserver.onChanged(capture(breweryListStates)) }

            breweryListStates shouldBe listOf(
                ResultStatus.Loading,
                ResultStatus.Success(listOf(brewery))
            )

            confirmVerified(breweryListRepository)
        }

    @Test
    fun `SHOULD Call getBreweryList() and THEN post error WHEN the call fails`() =
        runBlocking {

            val exception = Exception()

            coEvery { breweryListRepository.getBreweryList() } throws exception

            with(breweryListViewModel) {
                breweryListLiveData.observeForever(breweryListObserver)
                getBreweryList()
            }

            coVerify { breweryListRepository.getBreweryList() }

            verify { breweryListObserver.onChanged(capture(breweryListStates)) }

            breweryListStates shouldBe listOf(
                ResultStatus.Loading,
                ResultStatus.Error(exception)
            )

            confirmVerified(breweryListRepository)

        }
}