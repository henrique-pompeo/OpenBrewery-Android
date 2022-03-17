package com.henrique.brewerydetail.ui

import androidx.lifecycle.Observer
import com.henrique.brewerydetail.UnitTest
import com.henrique.brewerydetail.data.repository.BreweryDetailRepository
import com.henrique.brewerydetail.ui.viewmodel.BreweryDetailViewModel
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
class BreweryDetailViewModelTest : UnitTest() {

    private val breweryDetailRepository = mockk<BreweryDetailRepository>(relaxed = true)
    private val breweryDetailObserver = mockk<Observer<ResultStatus<Brewery>>>(relaxed = true)
    private val breweryDetailStates = mutableListOf<ResultStatus<Brewery>>()
    private val breweryDetailViewModel = BreweryDetailViewModel(breweryDetailRepository)

    private fun setUpViewModel() {
        breweryDetailViewModel.breweryDetailLiveData.observeForever(breweryDetailObserver)
        breweryDetailViewModel.getBreweryById("id")
    }

    @Test
    fun `SHOULD call getBreweryDetail() and THEN post success WHEN the call succeeds`() =
        runBlocking {

            coEvery { breweryDetailRepository.getBreweryById("id") } returns
                    ResultStatus.Success(brewery)

            setUpViewModel()

            coVerify(exactly = 1) { breweryDetailRepository.getBreweryById("id") }
            verify(exactly = 2) { breweryDetailObserver.onChanged(capture(breweryDetailStates)) }

            breweryDetailStates shouldBe listOf(
                ResultStatus.Loading,
                ResultStatus.Success(brewery)
            )
        }

    @Test
    fun `SHOULD Call getBreweryDetail() and THEN post error WHEN the call fails`() =
        runBlocking {

            val exception = Exception()

            coEvery { breweryDetailRepository.getBreweryById("id") } returns
                    ResultStatus.Error(exception.message)

            setUpViewModel()

            coVerify(exactly = 1) { breweryDetailRepository.getBreweryById("id") }
            verify(exactly = 2) { breweryDetailObserver.onChanged(capture(breweryDetailStates)) }

            breweryDetailStates shouldBe listOf(
                ResultStatus.Loading,
                ResultStatus.Error(exception.message)
            )
        }

}