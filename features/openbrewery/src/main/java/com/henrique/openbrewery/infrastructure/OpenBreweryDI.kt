package com.henrique.openbrewery.infrastructure

import com.henrique.openbrewery.infrastructure.brewerydetail.BreweryDetailDI
import com.henrique.openbrewery.infrastructure.brewerylist.BreweryListDI

object OpenBreweryDI {
    val module = BreweryListDI.module +
            BreweryDetailDI.module
}
