package com.henrique.openbrewery.presentation.brewerydetail.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetailState
import com.henrique.openbrewery.domain.brewerydetail.usecase.BreweryDetailUseCase
import com.henrique.openbrewery.util.StubFactory
import com.henrique.openbrewery.util.TestConstants
import io.mockk.CapturingSlot
import io.mockk.Runs
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verifySequence
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class BreweryDetailViewModelTest {
    private lateinit var breweryDetailViewModel: BreweryDetailViewModel
    private val breweryDetailUseCase: BreweryDetailUseCase = mockk(relaxed = true)

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        clearAllMocks()
        Dispatchers.setMain(StandardTestDispatcher())
        breweryDetailViewModel = getBreweryDetailViewModel()
    }

    @Test
    fun `Ensure breweryDetailState is Success WHEN getBreweryDetails is called`() {
        runBlocking {
            coEvery { breweryDetailUseCase.getBreweryDetails(TestConstants.id) } answers {
                BreweryDetailState.Success(StubFactory().breweryDetail())
            }

            breweryDetailViewModel.getBreweryDetails(TestConstants.id)

            assert(breweryDetailViewModel.breweryDetailState.value is BreweryDetailState.Success)

            //TODO -- CAPTURE STATE CHANGE FROM LOADING TO SUCCESS IN FUTURE
        }
    }

    @Test
    fun `Ensure breweryDetailState is Error WHEN getBreweryDetails is called`() {
        runBlocking {
            coEvery { breweryDetailUseCase.getBreweryDetails(TestConstants.id) } answers {
                BreweryDetailState.Error
            }

            breweryDetailViewModel.getBreweryDetails(TestConstants.id)

            assert(breweryDetailViewModel.breweryDetailState.value is BreweryDetailState.Error)

            //TODO -- CAPTURE STATE CHANGE FROM LOADING TO ERROR IN FUTURE
        }
    }

    private fun getBreweryDetailViewModel() = BreweryDetailViewModel(
        breweryDetailUseCase
    )
}