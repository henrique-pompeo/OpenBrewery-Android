package com.henrique.brewerylist.ui

import androidx.lifecycle.Observer
import com.henrique.brewerylist.UnitTest
import com.henrique.brewerylist.data.repository.BreweryListRepository
import com.henrique.shared.data.ResultStatus
import com.henrique.shared.domain.model.Brewery
import io.kotlintest.shouldBe
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.koin.core.component.KoinApiExtension


@KoinApiExtension
@ExperimentalCoroutinesApi
class BreweryListViewModelTest : UnitTest() {

    private val breweryListRepository = mockk<BreweryListRepository>(relaxed = true)
    private val breweryListObserver = mockk<Observer<ResultStatus<List<Brewery>>>>(relaxed = true)
    private val breweryListStates = mutableListOf<ResultStatus<List<Brewery>>>()

    private lateinit var breweryListViewModel : BreweryListViewModel

    private fun setUpViewModel() {
        breweryListViewModel = BreweryListViewModel(breweryListRepository)
        breweryListViewModel.breweryListLiveData.observeForever(breweryListObserver)
        breweryListViewModel.getBreweryList()
    }

    @Test
    fun `SHOULD call getBreweryList() and THEN post success WHEN the call succeeds`() =
        runBlocking {

            coEvery { breweryListRepository.getBreweryList() } returns
                    ResultStatus.Success(listOf(brewery))

            setUpViewModel()

            coVerify(exactly = 1) { breweryListRepository.getBreweryList() }
            verify(exactly = 2) { breweryListObserver.onChanged(capture(breweryListStates)) }

            breweryListStates shouldBe listOf(
                ResultStatus.Loading,
                ResultStatus.Success(listOf(brewery))
            )
        }

    @Test
    fun `SHOULD Call getBreweryList() and THEN post error WHEN the call fails`() =
        runBlocking {

            val exception = Exception()

            coEvery { breweryListRepository.getBreweryList() } returns
                    ResultStatus.Error(exception)

            setUpViewModel()

            coVerify(exactly = 1) { breweryListRepository.getBreweryList() }
            verify(exactly = 2) { breweryListObserver.onChanged(capture(breweryListStates)) }

            breweryListStates shouldBe listOf(
                ResultStatus.Loading,
                ResultStatus.Error(exception)
            )
        }
}