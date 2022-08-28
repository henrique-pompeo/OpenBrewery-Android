package com.henrique.openbrewery.features.brewerydetail.viewmodel

import androidx.lifecycle.Observer
import com.henrique.datasource.base.UnitTest
import com.henrique.datasource.brewerydetail.domain.interfaces.repository.BreweryDetailRepository
import com.henrique.openbrewery.features.brewerydetail.presentation.viewmodel.BreweryDetailViewModel
import com.henrique.datasource.data.ResultStatus
import com.henrique.datasource.domain.model.Brewery
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
class BreweryDetailViewModelTest : com.henrique.datasource.base.UnitTest() {

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

            verify(exactly = 2) { breweryDetailObserver.onChanged(capture(breweryDetailStates)) }

            Assert.assertEquals(
                breweryDetailStates,
                listOf(
                    ResultStatus.Loading,
                    ResultStatus.Success(brewery)
                )
            )

            coVerify(exactly = 1) { breweryDetailRepository.getBreweryById("id") }
        }

    @Test
    fun `SHOULD Call getBreweryDetail() and THEN post error WHEN the call fails`() =
        runBlocking {

            val exception = Exception()

            coEvery { breweryDetailRepository.getBreweryById("id") } returns
                    ResultStatus.Error(exception.message)

            setUpViewModel()

            verify(exactly = 2) { breweryDetailObserver.onChanged(capture(breweryDetailStates)) }

            Assert.assertEquals(
                breweryDetailStates,
                listOf(
                    ResultStatus.Loading,
                    ResultStatus.Error(exception.message)
                )
            )

            coVerify(exactly = 1) { breweryDetailRepository.getBreweryById("id") }
        }
}