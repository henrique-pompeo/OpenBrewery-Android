package com.henrique.brewerydetail.ui

import androidx.lifecycle.Observer
import com.henrique.brewerydetail.BreweryDetailTest
import com.henrique.shared.data.Result
import com.henrique.shared.domain.model.Brewery
import io.kotlintest.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import org.junit.After
import org.junit.Test
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
@ExperimentalCoroutinesApi
class BreweryDetailViewModelTest : BreweryDetailTest() {

    private val breweryDetailObserver = mockk<Observer<Result<Brewery>>>(relaxed = true)

    private val breweryDetailStates = mutableListOf<Result<Brewery>>()

    @Test
    fun `SHOULD call getBreweryDetail() and THEN post success WHEN the call succeeds`() =
        runBlocking {

            coEvery { breweryDetailRepository.getBreweryById("id") } returns brewery

            with(breweryDetailViewModel) {
                breweryDetail.observeForever(breweryDetailObserver)
                getBreweryById("id")
            }

            coVerify { breweryDetailRepository.getBreweryById("id") }

            verify { breweryDetailObserver.onChanged(capture(breweryDetailStates)) }

            breweryDetailStates shouldBe listOf(
                Result.Loading,
                Result.Success(brewery)
            )

            confirmVerified(breweryDetailRepository)
        }

    @Test
    fun `SHOULD Call getBreweryDetail() and THEN post error WHEN the call fails`() =
        runBlocking {

            val exception = Exception()

            coEvery { breweryDetailRepository.getBreweryById("id") } throws exception

            with(breweryDetailViewModel) {
                breweryDetail.observeForever(breweryDetailObserver)
                getBreweryById("id")
            }

            coVerify { breweryDetailRepository.getBreweryById("id") }

            verify { breweryDetailObserver.onChanged(capture(breweryDetailStates)) }

            breweryDetailStates shouldBe listOf(
                Result.Loading,
                Result.Error(exception)
            )

            confirmVerified(breweryDetailRepository)

        }

}