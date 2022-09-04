package com.henrique.openbrewery.features.brewerylist.viewmodel

import androidx.lifecycle.Observer
import com.henrique.openbrewery.infrastructure.UnitTest
import com.henrique.datasource.brewerylist.domain.interfaces.repository.BreweryListRepository
import com.henrique.datasource.brewerydetail.domain.model.BreweryStatus
import com.henrique.datasource.brewerydetail.domain.model.Brewery
import com.henrique.openbrewery.features.brewerylist.presentation.viewmodel.BreweryListViewModel
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
    private val breweryListObserver = mockk<Observer<BreweryStatus<List<Brewery>>>>(relaxed = true)
    private val breweryListStates = mutableListOf<BreweryStatus<List<Brewery>>>()
    private val breweryListViewModel = BreweryListViewModel(breweryListRepository)

    private fun setUpViewModel() {
        breweryListViewModel.breweryListLiveData.observeForever(breweryListObserver)
        breweryListViewModel.getBreweryList()
    }

    @Test
    fun `SHOULD call getBreweryList() and THEN post success WHEN the call succeeds`() =
        runBlocking {

            coEvery { breweryListRepository.getBreweryList() } returns
                    BreweryStatus.Success(listOf(brewery))

            setUpViewModel()

            verify(exactly = 2) { breweryListObserver.onChanged(capture(breweryListStates)) }

            Assert.assertEquals(
                breweryListStates,
                listOf(
                    BreweryStatus.Loading,
                    BreweryStatus.Success(listOf(brewery))
                )
            )

            coVerify(exactly = 1) { breweryListRepository.getBreweryList() }
        }

    @Test
    fun `SHOULD Call getBreweryList() and THEN post error WHEN the call fails`() =
        runBlocking {

            val exception = Exception()

            coEvery { breweryListRepository.getBreweryList() } returns
                    BreweryStatus.Error(exception.message)

            setUpViewModel()

            verify(exactly = 2) { breweryListObserver.onChanged(capture(breweryListStates)) }

            Assert.assertEquals(
                breweryListStates,
                listOf(
                    BreweryStatus.Loading,
                    BreweryStatus.Error(exception.message)
                )
            )

            coVerify(exactly = 1) { breweryListRepository.getBreweryList() }
        }
}