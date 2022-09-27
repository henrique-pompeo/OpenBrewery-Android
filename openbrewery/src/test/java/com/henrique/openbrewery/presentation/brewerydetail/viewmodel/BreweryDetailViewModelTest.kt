package com.henrique.openbrewery.presentation.brewerydetail.viewmodel

import androidx.lifecycle.Observer
import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetailState
import com.henrique.openbrewery.domain.brewerydetail.usecase.BreweryDetailUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
class BreweryDetailViewModelTest {

    private val breweryDetailUseCase = mockk<BreweryDetailUseCase>(relaxed = true)
    private val breweryDetailObserver = mockk<Observer<BreweryDetailState>>(relaxed = true)
    private val breweryDetailStates = mutableListOf<BreweryDetailState>()
    private val breweryDetailViewModel = BreweryDetailViewModel(breweryDetailUseCase)

//    private fun setUpViewModel() {
//        breweryDetailViewModel.breweryDetailLiveData.observeForever(breweryDetailObserver)
//        breweryDetailViewModel.getBreweryById("id")
//    }
//
//    @Test
//    fun `SHOULD call getBreweryDetail() and THEN post success WHEN the call succeeds`() =
//        runBlocking {
//
//            coEvery { breweryDetailRepository.getBreweryDetails("id") } returns
//                    BreweryDetailState.Success(brewery)
//
//            setUpViewModel()
//
//            verify(exactly = 2) { breweryDetailObserver.onChanged(capture(breweryDetailStates)) }
//
//            Assert.assertEquals(
//                breweryDetailStates,
//                listOf(
//                    BreweryDetailState.Loading,
//                    BreweryDetailState.Success(brewery)
//                )
//            )
//
//            coVerify(exactly = 1) { breweryDetailRepository.getBreweryDetails("id") }
//        }
//
//    @Test
//    fun `SHOULD Call getBreweryDetail() and THEN post error WHEN the call fails`() =
//        runBlocking {
//
//            val exception = Exception()
//
//            coEvery { breweryDetailRepository.getBreweryDetails("id") } returns
//                    BreweryDetailState.Error(exception.message)
//
//            setUpViewModel()
//
//            verify(exactly = 2) { breweryDetailObserver.onChanged(capture(breweryDetailStates)) }
//
//            Assert.assertEquals(
//                breweryDetailStates,
//                listOf(
//                    BreweryDetailState.Loading,
//                    BreweryDetailState.Error(exception.message)
//                )
//            )
//
//            coVerify(exactly = 1) { breweryDetailRepository.getBreweryDetails("id") }
//        }
}