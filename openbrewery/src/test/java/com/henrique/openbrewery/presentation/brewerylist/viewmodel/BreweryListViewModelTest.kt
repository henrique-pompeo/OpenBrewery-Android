package com.henrique.openbrewery.presentation.brewerylist.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.henrique.openbrewery.domain.brewerylist.model.BreweryListState
import com.henrique.openbrewery.domain.brewerylist.usecase.BreweryListUseCase
import com.henrique.openbrewery.util.StubFactory
import com.henrique.openbrewery.util.TestConstants
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class BreweryListViewModelTest {
    private lateinit var breweryListViewModel: BreweryListViewModel
    private val breweryListUseCase: BreweryListUseCase = mockk(relaxed = true)

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        clearAllMocks()
        Dispatchers.setMain(StandardTestDispatcher())
        breweryListViewModel = getBreweryListViewModel()
    }

    @Test
    fun `Ensure breweryListState is Success WHEN getBreweryLists is called`() {
        runBlocking {
            coEvery { breweryListUseCase.getBreweryList() } answers {
                BreweryListState.Success(StubFactory().breweryList())
            }

            breweryListViewModel.getBreweryList()

            assert(breweryListViewModel.breweryListState.value is BreweryListState.Success)

            //TODO -- CAPTURE STATE CHANGE FROM LOADING TO SUCCESS IN FUTURE
        }
    }

    @Test
    fun `Ensure breweryListState is Error WHEN getBreweryLists is called`() {
        runBlocking {
            coEvery { breweryListUseCase.getBreweryList() } answers {
                BreweryListState.Error
            }

            breweryListViewModel.getBreweryList()

            assert(breweryListViewModel.breweryListState.value is BreweryListState.Error)

            //TODO -- CAPTURE STATE CHANGE FROM LOADING TO ERROR IN FUTURE
        }
    }

    @Test
    fun `Ensure clickedBrewery has some brewery id WHEN itemClicked is called`() {
        runBlocking {
            assert(breweryListViewModel.clickedBrewery.value == null)
            breweryListViewModel.itemClicked(TestConstants.id)
            assert(breweryListViewModel.clickedBrewery.value == TestConstants.id)
        }
    }

    private fun getBreweryListViewModel() = BreweryListViewModel(
        breweryListUseCase
    )    
}