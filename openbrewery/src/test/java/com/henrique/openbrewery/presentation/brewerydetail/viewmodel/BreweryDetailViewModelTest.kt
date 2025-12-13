package com.henrique.openbrewery.presentation.brewerydetail.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.henrique.openbrewery.brewerydetail.domain.model.BreweryDetailState
import com.henrique.openbrewery.brewerydetail.domain.usecase.BreweryDetailUseCase
import com.henrique.openbrewery.brewerydetail.presentation.viewmodel.BreweryDetailViewModel
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
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class BreweryDetailViewModelTest {
    private val breweryDetailViewModel: BreweryDetailViewModel = getBreweryDetailViewModel()
    private val breweryDetailUseCase: BreweryDetailUseCase = mockk(relaxed = true)

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Ensure breweryDetailState is Success WHEN getBreweryDetails is called`() {
        runBlocking {
            coEvery { breweryDetailUseCase.getBreweryDetails(TestConstants.id) } answers {
                BreweryDetailState.Success(StubFactory().breweryDetail())
            }

            breweryDetailViewModel.getBreweryDetails(TestConstants.id)

            assert(breweryDetailViewModel.breweryDetailState.value is BreweryDetailState.Success)
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
        }
    }

    private fun getBreweryDetailViewModel() = BreweryDetailViewModel(
        breweryDetailUseCase
    )
}
