package com.henrique.brewerylist.ui.viewholder

import com.henrique.brewerylist.InstrumentedTest
import com.henrique.shared.domain.model.Brewery
import io.mockk.verify
import org.junit.Assert
import org.junit.Test
import org.koin.core.component.KoinApiExtension
import org.koin.core.module.Module

@KoinApiExtension
class BreweryListViewHolderTest : InstrumentedTest() {

    //TODO --- MISSING CONTENT -- COME BACK HERE AFTER BREWERY LIST AND DETAIL REFACTORING

//    @Test
//    fun givenBreweryListViewHolderShouldHaveAllValuesWhenItsCreated() {
//        val name = "name"
//        val country = "country"
//        val phone = "phone"
//        createViewHolder(brewery)
//
//        with(itemBinding) {
//            Assert.assertEquals(breweryListItemTitle.text, name)
//            Assert.assertEquals(breweryListItemAddress.text, country)
//            Assert.assertEquals(breweryListItemPhone.text, phone)
//        }
//    }
//
//    @Test
//    fun givenBreweryListViewHolderShouldListenFromCallBackWhenItsClicked() {
//        val id = "id"
//        createViewHolder(brewery)
//
//        itemBinding.root.performClick()
//
//        verify {  }//TODO --- VERIFY IF THE BUTTON WAS CLICKED
//    }
//
//    private fun createViewHolder(brewery: Brewery): BreweryListViewHolder {
//        val holder = BreweryListViewHolder(itemBinding, navController)
//        holder.bind(brewery)
//        return holder
//    }
}