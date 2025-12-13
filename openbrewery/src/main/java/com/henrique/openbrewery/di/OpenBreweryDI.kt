package com.henrique.openbrewery.di

import com.henrique.openbrewery.brewerylist.di.BreweryListDI
import com.henrique.openbrewery.brewerydetail.di.BreweryDetailDI

object OpenBreweryDI {
    val module = BreweryListDI.module + BreweryDetailDI.module
}
