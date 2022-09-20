package com.henrique.openbrewery.presentation.navigation

import androidx.navigation.NavController
import com.henrique.openbrewery.domain.navigation.BreweryNavigation
import com.henrique.openbrewery.presentation.brewerylist.fragment.BreweryListFragmentDirections

class BreweryNavigationImpl(private val navController: NavController) : BreweryNavigation {
    override fun goToBreweryDetails() {
        navController.navigate(
            BreweryListFragmentDirections.actionBreweryListFragmentToBreweryDetailFragment()
        )
    }
}