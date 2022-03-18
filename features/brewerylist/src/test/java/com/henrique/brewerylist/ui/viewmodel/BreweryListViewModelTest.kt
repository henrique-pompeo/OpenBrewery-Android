package com.henrique.brewerylist.ui.viewmodel

import androidx.lifecycle.Observer
import com.henrique.brewerylist.UnitTest
import com.henrique.brewerylist.data.repository.BreweryListRepository
import com.henrique.shared.data.ResultStatus
import com.henrique.shared.domain.model.Brewery
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
@ExperimentalCoroutinesApi
class BreweryListViewModelTest : UnitTest() {

    private val breweryListRepository = mockk<BreweryListRepository>(relaxed = true)
    private val breweryListObserver = mockk<Observer<ResultStatus<List<Brewery>>>>(relaxed = true)
    private val breweryListStates = mutableListOf<ResultStatus<List<Brewery>>>()
    private val breweryListViewModel = BreweryListViewModel(breweryListRepository)

    private fun setUpViewModel() {
        breweryListViewModel.breweryListLiveData.observeForever(breweryListObserver)
        breweryListViewModel.getBreweryList()
    }

    @Test
    fun `SHOULD call getBreweryList() and THEN post success WHEN the call succeeds`() =
        runBlocking {

            coEvery { breweryListRepository.getBreweryList() } returns
                    ResultStatus.Success(listOf(brewery))

            setUpViewModel()

            verify(exactly = 2) { breweryListObserver.onChanged(capture(breweryListStates)) }

            Assert.assertEquals(
                breweryListStates,
                listOf(
                    ResultStatus.Loading,
                    ResultStatus.Success(listOf(brewery))
                )
            )

            coVerify(exactly = 1) { breweryListRepository.getBreweryList() }
        }

    @Test
    fun `SHOULD Call getBreweryList() and THEN post error WHEN the call fails`() =
        runBlocking {

            val exception = Exception()

            coEvery { breweryListRepository.getBreweryList() } returns
                    ResultStatus.Error(exception.message)

            setUpViewModel()

            verify(exactly = 2) { breweryListObserver.onChanged(capture(breweryListStates)) }

            Assert.assertEquals(
                breweryListStates,
                listOf(
                    ResultStatus.Loading,
                    ResultStatus.Error(exception.message)
                )
            )

            coVerify(exactly = 1) { breweryListRepository.getBreweryList() }
        }
}