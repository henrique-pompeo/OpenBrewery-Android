package com.henrique.openbrewery.infrastructure

import com.henrique.openbrewery.infrastructure.brewery.BreweryDI
import com.henrique.openbrewery.infrastructure.brewerydetail.BreweryDetailDI
import com.henrique.openbrewery.infrastructure.brewerylist.BreweryListDI
import com.henrique.openbrewery.infrastructure.navigation.NavigationDI

object OpenBreweryDI {
    val module = BreweryDI.module +
            BreweryListDI.module +
            BreweryDetailDI.module +
            NavigationDI.module
}
