package com.henrique.app.ui.brewerylist

import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.henrique.app.InstrumentedTest
import com.henrique.brewerylist.data.repository.BreweryListRepository
import com.henrique.brewerylist.ui.viewmodel.BreweryListViewModel
import com.henrique.shared.domain.model.Brewery
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import org.junit.runner.RunWith
import org.koin.core.component.KoinApiExtension
import org.koin.dsl.module

@KoinApiExtension
@RunWith(AndroidJUnit4::class)
class BreweryListFragmentTest : InstrumentedTest() {

    private val breweryListViewModel = mockk<BreweryListViewModel>(relaxed = true)

    private val breweryListRepository = mockk<BreweryListRepository>(relaxed = true)

    private val breweryListMutableLiveData = MutableLiveData<Result<List<Brewery>>>()

    override fun getModule() = module(override = true) {
        single(override = true) { breweryListRepository }
        single(override = true) { breweryListViewModel }
    }

    override fun initialize() {
        every { breweryListViewModel.getBreweryList() } just Runs
        coEvery { breweryListRepository.getBreweryList() } returns listOf(brewery)
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