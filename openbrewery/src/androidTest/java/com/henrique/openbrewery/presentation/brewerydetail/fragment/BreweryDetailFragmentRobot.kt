package com.henrique.openbrewery.presentation.brewerydetail.fragment

import com.henrique.openbrewery.base.BaseTestRobot
import com.henrique.openbrewery.R

fun breweryDetailRobot(func: BreweryDetailFragmentRobot.() -> Unit) =
    BreweryDetailFragmentRobot().apply { func() }

class BreweryDetailFragmentRobot : BaseTestRobot() {

    fun assertBreweryName(name: String) {
        matchText(R.id.brewery_detail_brewery_name_text, name)
    }

    fun assertBreweryType(type: String) {
        matchText(R.id.brewery_detail_brewery_type_text, type)
    }

    fun assertBreweryAddress(address: String) {
        matchText(R.id.brewery_detail_address_text, address)
    }

    fun assertBreweryPhone(phone: String) {
        matchText(R.id.brewery_detail_phone_text, phone)
    }

    fun assertBreweryWebsite(website: String) {
        matchText(R.id.brewery_detail_website_text, website)
    }

    fun assertBreweryStreet(street: String) {
        matchText(R.id.brewery_detail_street_text, street)
    }

    fun assertBreweryPostalCode(postalCode: String) {
        matchText(R.id.brewery_detail_postal_code_text, postalCode)
    }

    fun assertBreweryCity(city: String) {
        matchText(R.id.brewery_detail_city_text, city)
    }

    fun assertBreweryCountry(country: String) {
        matchText(R.id.brewery_detail_country_text, country)
    }

    fun assertBreweryTypeDescription(description: String) {
        matchText(R.id.brewery_detail_fragment_brewery_type_desc_tv, description)
    }

    fun assertLoadingVisibility(visibility: Int) {
        matchViewVisible(R.id.brewery_detail_loading_pb)
    }

    fun assertErrorVisibility(visibility: Int) {
        matchViewVisible(R.id.brewery_detail_error_cl)
    }
}