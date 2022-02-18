package com.henrique.app.ui.brewerydetail

import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.henrique.app.InstrumentedTest
import com.henrique.brewerydetail.data.repository.BreweryDetailRepository
import com.henrique.brewerydetail.ui.BreweryDetailViewModel
import com.henrique.shared.domain.model.Brewery
import io.mockk.mockk
import io.mockk.every
import io.mockk.coEvery
import io.mockk.Runs
import io.mockk.just
import org.junit.runner.RunWith
import org.koin.core.component.KoinApiExtension
import org.koin.dsl.module

@KoinApiExtension
@RunWith(AndroidJUnit4::class)
class BreweryDetailFragmentTest : InstrumentedTest() {

    private val breweryDetailViewModel = mockk<BreweryDetailViewModel>(relaxed = true)

    private val breweryDetailRepository = mockk<BreweryDetailRepository>(relaxed = true)

    private val breweryDetailMutableLiveData = MutableLiveData<Result<Brewery>>()

    override fun getModule() = module(override = true) {
        single(override = true) { breweryDetailRepository }
        single(override = true) { breweryDetailViewModel }
    }

    override fun initialize() {
        every { breweryDetailViewModel.getBreweryById(any()) } just Runs
        coEvery { breweryDetailRepository.getBreweryById("id") } returns brewery
    }

    companion object {

        val brewery = Brewery(
            id = "id",
            name = "name",
            breweryType = "breweryType",
            street = "street",
            address2 = "address2",
            address3 = "address3",
            city = "city",
            state = "state",
            countyProvince = "countyProvince",
            postalCode = "postalCode",
            country = "country",
            longitude = "longitude",
            latitude = "latitude",
            phone = "phone",
            websiteUrl = "websiteUrl",
            updatedAt = "2021-10-23T02:24:55.243Z",
            createdAt = "2021-10-23T02:24:55.243Z"
        )

    }

    //TODO COLOCAR MÉTODOS DE CHECAGEM E CLICK NOS COMPONENTES SE NECESSÁRIO
    // CRIAR OS TESTES PARA SUCESSO E FALHA (OUTROS SE NECESSÁRIO)
    // REFATORAR OS TESTES PARA COMPANION OBJECT
}