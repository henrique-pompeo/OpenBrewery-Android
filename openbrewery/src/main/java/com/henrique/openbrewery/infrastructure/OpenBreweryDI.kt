package com.henrique.openbrewery.infrastructure

import com.henrique.openbrewery.infrastructure.brewery.BreweryDI
import com.henrique.openbrewery.infrastructure.brewerydetail.BreweryDetailDI
import com.henrique.openbrewery.infrastructure.brewerylist.BreweryListDI

object OpenBreweryDI {
    val module = BreweryDI.module +
            BreweryListDI.module +
            BreweryDetailDI.module
}
