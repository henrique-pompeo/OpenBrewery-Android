package com.henrique.openbrewery.presentation.brewerylist.viewmodel

import androidx.lifecycle.Observer
import com.henrique.openbrewery.infrastructure.UnitTest
import com.henrique.datasource.datasource.brewerylist.domain.interfaces.repository.BreweryListRepository
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetailState
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
class BreweryListViewModelTest : UnitTest() {

    private val breweryListRepository = mockk<BreweryListRepository>(relaxed = true)
    private val breweryListObserver = mockk<Observer<BreweryDetailState<List<BreweryDetail>>>>(relaxed = true)
    private val breweryListStates = mutableListOf<BreweryDetailState<List<BreweryDetail>>>()
    private val breweryListViewModel = BreweryListViewModel(breweryListRepository)

    private fun setUpViewModel() {
        breweryListViewModel.breweryListLiveData.observeForever(breweryListObserver)
        breweryListViewModel.getBreweryList()
    }

    @Test
    fun `SHOULD call getBreweryList() and THEN post success WHEN the call succeeds`() =
        runBlocking {

            coEvery { breweryListRepository.getBreweryList() } returns
                    BreweryDetailState.Success(listOf(brewery))

            setUpViewModel()

            verify(exactly = 2) { breweryListObserver.onChanged(capture(breweryListStates)) }

            Assert.assertEquals(
                breweryListStates,
                listOf(
                    BreweryDetailState.Loading,
                    BreweryDetailState.Success(listOf(brewery))
                )
            )

            coVerify(exactly = 1) { breweryListRepository.getBreweryList() }
        }

    @Test
    fun `SHOULD Call getBreweryList() and THEN post error WHEN the call fails`() =
        runBlocking {

            val exception = Exception()

            coEvery { breweryListRepository.getBreweryList() } returns
                    BreweryDetailState.Error(exception.message)

            setUpViewModel()

            verify(exactly = 2) { breweryListObserver.onChanged(capture(breweryListStates)) }

            Assert.assertEquals(
                breweryListStates,
                listOf(
                    BreweryDetailState.Loading,
                    BreweryDetailState.Error(exception.message)
                )
            )

            coVerify(exactly = 1) { breweryListRepository.getBreweryList() }
        }
}