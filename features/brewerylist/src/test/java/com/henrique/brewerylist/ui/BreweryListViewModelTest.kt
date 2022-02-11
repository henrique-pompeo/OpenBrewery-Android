package com.henrique.brewerylist.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.henrique.brewerylist.BreweryListTest
import com.henrique.brewerylist.data.repository.BreweryListRepository
import com.henrique.shared.data.Result
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Assert
import org.junit.After
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.core.component.KoinApiExtension
import org.koin.dsl.module
import org.koin.test.KoinTestRule

@KoinApiExtension
@ExperimentalCoroutinesApi
class BreweryListViewModelTest : BreweryListTest() {

    private val testDispatcher =  TestCoroutineDispatcher()

    private lateinit var breweryListViewModel: BreweryListViewModel

    private val breweryListRepository = mockk<BreweryListRepository>()

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

        coEvery { breweryListRepository.getBreweryList() } returns listOf(brewery)

        breweryListViewModel = BreweryListViewModel(breweryListRepository)
    }

    @Test
    fun `SHOULD call getBreweryList() and THEN post success WHEN the call succeeds`() = runBlocking {

        breweryListViewModel.getBreweryList()

        breweryListViewModel.breweryList.value.let {
            Assert.assertEquals(it, Result.Success(listOf(brewery)))
        }

        coVerify(exactly = 1) { breweryListRepository.getBreweryList() }

        confirmVerified(breweryListRepository)
    }

    @Test
    fun `SHOULD Call getBreweryList() and THEN post error WHEN the call fails`() = runBlocking {

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

}