package com.henrique.openbrewery.domain.brewerydetail.model

enum class BreweryType(val value: String) {
    MICRO("micro"),
    NANO("nano"),
    REGIONAL("regional"),
    BREWPUB("brewpub"),
    LARGE("large"),
    PLANNING("planning"),
    BAR("bar"),
    CONTRACT("contract"),
    PROPRIETOR("proprietor"),
    CLOSED("closed")
}