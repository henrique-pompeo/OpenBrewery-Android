package com.henrique.brewerylist.ui.adapter

import android.view.LayoutInflater
import com.henrique.brewerylist.InstrumentedTest
import com.henrique.brewerylist.databinding.BreweryListItemBinding
import com.henrique.brewerylist.ui.viewholder.BreweryListViewHolder
import io.mockk.verify
import org.junit.Assert
import org.junit.Test
import org.koin.core.component.KoinApiExtension
import org.mockito.internal.matchers.InstanceOf

@KoinApiExtension
class BreweryListAdapterTest : InstrumentedTest() {

    @Test
    fun givenBreweryListAdapterShouldNotHaveItemsWhenDoesntHaveDataInTheList() {
        Assert.assertEquals(adapter.itemCount, 0)
    }

    @Test
    fun givenBreweryListAdapterShouldHaveSameAmountItemsFromGivenList() {
        Assert.assertEquals(adapter.itemCount, list.size)
    }

    @Test
    fun givenBreweryListAdapterShouldBindCorrectPositionWhenBindViewHolderIsCalled() {
        val itemBinding = BreweryListItemBinding.inflate(LayoutInflater.from(context), layout, false)
        val holder = BreweryListViewHolder(itemBinding, navController)
        val position = 0

        adapter.bindViewHolder(holder, position)

        verify { holder.bind(list[position]) }
    }

    @Test
    fun givenBreweryListAdapterShouldCreateHolderCorrectlyWhenOnCreateViewHolderIsCalled() {
        val holder = adapter.onCreateViewHolder(layout, -1)
        Assert.assertEquals(holder, InstanceOf(BreweryListViewHolder::class.java))
    }
}