package com.henrique.app.ui.brewerydetail

import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.henrique.app.InstrumentedTest
import com.henrique.brewerydetail.ui.BreweryDetailViewModel
import com.henrique.shared.domain.model.Brewery
import io.mockk.mockk
import io.mockk.every
import io.mockk.Runs
import io.mockk.just
import com.henrique.shared.data.Result
import org.junit.runner.RunWith
import org.koin.core.component.KoinApiExtension
import org.koin.dsl.module

@KoinApiExtension
@RunWith(AndroidJUnit4::class)
class BreweryDetailFragmentTest : InstrumentedTest() {

    private val breweryDetailViewModel = mockk<BreweryDetailViewModel>(relaxed = true)

    private val breweryDetailMutableLiveData = MutableLiveData<Result<Brewery>>()

    override fun getModule() = module(override = true) {
        single(override = true) { breweryDetailViewModel }
    }

    override fun initialize() {
        every { breweryDetailViewModel.getBreweryById(any()) } just Runs
        every { breweryDetailViewModel.breweryDetail } returns breweryDetailMutableLiveData
    }


}