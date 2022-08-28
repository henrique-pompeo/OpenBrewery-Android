package com.henrique.openbrewery.infrastructure

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.ViewModelStore
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.statement.UiThreadStatement
import com.henrique.openbrewery.R
import com.henrique.openbrewery.features.brewerylist.presentation.fragment.BreweryListFragment
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
abstract class InstrumentedTest {

    fun launchBreweryListFragment() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())

        UiThreadStatement.runOnUiThread {
            navController.setViewModelStore(ViewModelStore())
            navController.setGraph(R.navigation.brewerylist_nav)
        }

        launchFragmentInContainer {
            BreweryListFragment().also { fragment ->
                fragment.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                    if (viewLifecycleOwner != null) {
                        Navigation.setViewNavController(fragment.requireView(), navController)
                    }
                }
            }
        }
    }
}
