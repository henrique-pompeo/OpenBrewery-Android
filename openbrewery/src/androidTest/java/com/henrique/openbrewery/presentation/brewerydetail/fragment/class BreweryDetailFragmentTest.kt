package com.henrique.openbrewery.presentation.brewerydetail.fragment

import android.view.View
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetailState
import com.henrique.openbrewery.presentation.brewerydetail.viewmodel.BreweryDetailViewModel
import com.henrique.openbrewery.presentation.brewerylist.viewmodel.BreweryListViewModel
import com.henrique.openbrewery.R
import com.henrique.openbrewery.util.StubFactory
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin
import org.koin.dsl.module

@RunWith(AndroidJUnit4::class)
class BreweryDetailFragmentTest {

    private val breweryListViewModel: BreweryListViewModel = mockk(relaxed = true)
    private val viewModel: BreweryDetailViewModel = mockk(relaxed = true)
    private val breweryDetailState: MutableLiveData<BreweryDetailState> = mockk(relaxed = true)

    @Before
    fun setup() {

        startKoin {
            modules(module {
                single { breweryListViewModel }
                single { viewModel }
            })
        }

        launchFragmentInContainer<BreweryDetailFragment>()
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun breweryDetailFragmentTestOpenedWithSuccess() {

        val scenario = launchFragmentInContainer<BreweryDetailFragment>()

        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )

        scenario.onFragment {
            navController.setGraph(R.navigation.openbrewery_navigation)
            navController.setCurrentDestination(R.id.breweryDetailFragment)
            Navigation.setViewNavController(it.requireView(), navController)
        }

        every { breweryListViewModel.clickedBrewery } answers {
            MutableLiveData(StubFactory().breweryDetail().id)
        }

        every { breweryDetailState.value } answers { BreweryDetailState.Loading }

        // Mock viewModel.breweryDetailState to return the MutableLiveData instance
        every { viewModel.breweryDetailState } answers { breweryDetailState }

        breweryDetailRobot {
            assertLoadingVisibility(View.VISIBLE)
        }

        // When getBreweryDetails(id: String) is called, change the value of breweryDetailState to emit Success state
        coEvery { viewModel.getBreweryDetails(any()) } just Runs

        // Call getBreweryDetails(id: String)
        viewModel.getBreweryDetails(StubFactory().breweryDetail().id)

        every { breweryDetailState.value } answers {
            BreweryDetailState.Success(StubFactory().breweryDetail())
        }

        // Use the robot to assert that the loading ProgressBar is gone and the TextViews are filled
        breweryDetailRobot {
            assertLoadingVisibility(View.GONE)
            assertBreweryName("Brewery Name")
            // Add more assertions for the other TextViews
        }

    }

    @Test
    fun breweryDetailFragmentTestOpenedWithError() {

    }

    @Test
    fun breweryDetailFragmentTestOpenedWithLoading() {

    }
}