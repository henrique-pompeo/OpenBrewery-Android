package com.henrique.openbrewery.presentation.navigation

import androidx.navigation.NavController
import com.henrique.openbrewery.domain.navigation.BreweryNavigation
import com.henrique.openbrewery.presentation.brewerylist.fragment.BreweryListFragmentDirections
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class BreweryNavigationImplTest {
    private val navController: NavController = mockk(relaxed = true)
    private lateinit var breweryNavigation: BreweryNavigation

    @Before
    fun setup() {
        breweryNavigation = getBreweryNavigation()
    }

    @Test
    fun `Ensure actionBreweryListFragmentToBreweryDetailFragment is called WHEN goToBreweryDetails is called`() {
        breweryNavigation.goToBreweryDetails()
        verify(exactly = 1) {
            navController.navigate(
                BreweryListFragmentDirections.actionBreweryListFragmentToBreweryDetailFragment()
            )
        }
    }

    private fun getBreweryNavigation() = BreweryNavigationImpl(navController)
}