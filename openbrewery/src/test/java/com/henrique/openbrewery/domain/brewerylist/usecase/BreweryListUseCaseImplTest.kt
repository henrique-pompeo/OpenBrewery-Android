package com.henrique.openbrewery.domain.brewerylist.usecase

import com.henrique.openbrewery.brewerylist.domain.interfaces.repository.BreweryListRepository
import com.henrique.openbrewery.domain.brewery.mappers.BreweryMapper
import com.henrique.openbrewery.brewerylist.domain.model.BreweryListState
import com.henrique.openbrewery.brewerylist.domain.usecase.BreweryListUseCase
import com.henrique.openbrewery.brewerylist.domain.usecase.BreweryListUseCaseImpl
import com.henrique.openbrewery.util.StubFactory
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Test

class BreweryListUseCaseImplTest {
    private val breweryListUseCase: BreweryListUseCase = getBreweryListUseCase()
    private val breweryMapper: BreweryMapper = mockk(relaxed = true)
    private val breweryListRepository: BreweryListRepository = mockk(relaxed = true)

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `Ensure getBreweryList returns success WHEN repository calls getBreweryList`() {
        runBlocking {
            every { breweryMapper.toList(StubFactory().datasourceBreweryList()) } answers {
                StubFactory().breweryList()
            }
            coEvery { breweryListRepository.getBreweryList() } answers {
                StubFactory().datasourceBreweryList()
            }

            var breweryListState: BreweryListState = BreweryListState.Error

            assert(breweryListState == BreweryListState.Error)

            breweryListState = breweryListUseCase.getBreweryList()

            assert(breweryListState == BreweryListState.Success(StubFactory().breweryList()))

            coVerify(exactly = 1) { breweryListRepository.insertBreweryList(StubFactory().datasourceBreweryList()) }
        }
    }

    @Test
    fun `Ensure getBreweryList returns error WHEN repository calls getBreweryList AND fails`() {
        runBlocking {
            every { breweryMapper.toList(StubFactory().datasourceBreweryList()) } answers {
                StubFactory().breweryList()
            }
            coEvery { breweryListRepository.getBreweryList() } throws (Exception("Error"))

            var breweryListState: BreweryListState = BreweryListState.Error

            assert(breweryListState == BreweryListState.Error)

            breweryListState = breweryListUseCase.getBreweryList()

            assert(breweryListState == BreweryListState.Error)
        }
    }

    @Test
    fun `Ensure getDatabaseBreweryList returns success WHEN repository calls getDatabaseBreweryList`() {
        runBlocking {
            every { breweryMapper.toList(StubFactory().datasourceBreweryList()) } answers {
                StubFactory().breweryList()
            }
            coEvery { breweryListRepository.getDatabaseBreweryList() } answers {
                StubFactory().datasourceBreweryList()
            }

            var breweryListState: BreweryListState = BreweryListState.Error

            assert(breweryListState == BreweryListState.Error)

            breweryListState = breweryListUseCase.getDatabaseBreweryList()

            assert(breweryListState == BreweryListState.Success(StubFactory().breweryList()))
        }
    }

    @Test
    fun `Ensure getDatabaseBreweryList returns error WHEN repository calls getDatabaseBreweryList AND fails`() {
        runBlocking {
            every { breweryMapper.toList(StubFactory().datasourceBreweryList()) } answers {
                StubFactory().breweryList()
            }
            coEvery { breweryListRepository.getDatabaseBreweryList() } throws (Exception("Error"))

            var breweryListState: BreweryListState = BreweryListState.Error

            assert(breweryListState == BreweryListState.Error)

            breweryListState = breweryListUseCase.getDatabaseBreweryList()

            assert(breweryListState == BreweryListState.Error)
        }
    }

    private fun getBreweryListUseCase() = BreweryListUseCaseImpl(
        breweryMapper, breweryListRepository
    )
}
