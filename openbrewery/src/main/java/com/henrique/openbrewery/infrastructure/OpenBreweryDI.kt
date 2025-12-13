package com.henrique.openbrewery.infrastructure

import com.henrique.openbrewery.brewerylist.di.BreweryListDI
import com.henrique.openbrewery.infrastructure.brewerydetail.BreweryDetailDI

object OpenBreweryDI {
    val module = BreweryListDI.module + BreweryDetailDI.module
}
