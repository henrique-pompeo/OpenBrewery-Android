package com.henrique.brewerylist.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.henrique.brewerylist.BreweryListTest
import com.henrique.brewerylist.data.repository.BreweryListRepository
import com.henrique.shared.data.Result
import com.henrique.shared.domain.model.Brewery
import io.kotlintest.matchers.exactly
import io.kotlintest.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.After
import org.junit.Assert
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.core.component.KoinApiExtension
import org.koin.dsl.module
import org.koin.test.KoinTestRule

@KoinApiExtension
@ExperimentalCoroutinesApi
class BreweryListViewModelTest : BreweryListTest() {

    private lateinit var breweryListViewModel: BreweryListViewModel

    private val breweryListObserver = mockk<Observer<Result<List<Brewery>>>>(relaxed = true)

    private val breweryListStates = mutableListOf<Result<List<Brewery>>>()

    private val breweryListRepository = mockk<BreweryListRepository>()

    private val testDispatcher =  TestCoroutineDispatcher()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(
            module {
                single { breweryListRepository }
            }
        )
    }

    @Before
    fun setup() {
        with(Dispatchers) { setMain(testDispatcher) }

        breweryListViewModel = BreweryListViewModel(
            breweryListRepository = breweryListRepository
        )
    }

    @Test
    fun `SHOULD call getBreweryList() and THEN post success WHEN the call succeeds`() =
        runBlocking {

            coEvery { breweryListRepository.getBreweryList() } returns listOf(brewery)

            with(breweryListViewModel) {
                breweryList.observeForever(breweryListObserver)
                getBreweryList()
            }

            coVerify { breweryListRepository.getBreweryList() }

            verify { breweryListObserver.onChanged(capture(breweryListStates)) }

            breweryListStates shouldBe listOf(
                Result.Loading,
                Result.Success(listOf(brewery))
            )

            confirmVerified(breweryListRepository)
        }

    @Test
    fun `SHOULD Call getBreweryList() and THEN post error WHEN the call fails`() = runBlocking {
        // TODO
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

}