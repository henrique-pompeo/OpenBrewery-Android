package com.henrique.brewerylist.ui.viewholder

import androidx.test.platform.app.InstrumentationRegistry
import com.henrique.brewerylist.InstrumentedTest
import com.henrique.shared.domain.model.Brewery
import io.mockk.verify
import org.junit.Assert
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.android.java.KoinAndroidApplication
import org.koin.core.component.KoinApiExtension
import org.koin.core.context.startKoin
import org.koin.dsl.module

@KoinApiExtension
class BreweryListViewHolderTest : InstrumentedTest() {    

    @Test
    fun givenBreweryListViewHolderShouldHaveAllValuesWhenItsCreated() {
        val name = "name"
        val country = "country"
        val phone = "phone"
        createViewHolder(brewery)

        with(itemBinding) {
            Assert.assertEquals(breweryListItemTitle.text, name)
            Assert.assertEquals(breweryListItemAddress.text, country)
            Assert.assertEquals(breweryListItemPhone.text, phone)
        }
    }

    @Test
    fun givenBreweryListViewHolderShouldListenFromCallBackWhenItsClicked() {
        val id = "id"
        createViewHolder(brewery)

        itemBinding.root.performClick()

        verify {  }//TODO --- VERIFY IF THE BUTTON WAS CLICKED
    }

    private fun createViewHolder(brewery: Brewery): BreweryListViewHolder {
        val holder = BreweryListViewHolder(itemBinding, navController)
        holder.bind(brewery)
        return holder
    }
}