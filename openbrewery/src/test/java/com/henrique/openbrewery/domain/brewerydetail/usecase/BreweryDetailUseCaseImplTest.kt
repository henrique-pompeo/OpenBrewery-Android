package com.henrique.openbrewery.domain.brewerydetail.usecase

import com.henrique.datasource.datasource.brewerydetail.domain.interfaces.repository.BreweryDetailRepository
import com.henrique.openbrewery.domain.brewerydetail.mappers.BreweryDetailMapper
import com.henrique.openbrewery.domain.brewerydetail.model.BreweryDetailState
import com.henrique.openbrewery.util.StubFactory
import com.henrique.openbrewery.util.TestConstants
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class BreweryDetailUseCaseImplTest {
    private lateinit var breweryDetailUseCase: BreweryDetailUseCase
    private val breweryDetailMapper: BreweryDetailMapper = mockk(relaxed = true)
    private val breweryDetailRepository: BreweryDetailRepository = mockk(relaxed = true)

    @Before
    fun setup() {
        clearAllMocks()
        breweryDetailUseCase = getBreweryDetailUseCase()
    }

    @Test
    fun `Ensure getBreweryDetails returns success WHEN repository calls getBreweryDetails`() {
        runBlocking {
            every { breweryDetailMapper.toDomain(StubFactory().datasourceBreweryDetail()) } answers {
                StubFactory().breweryDetail()
            }
            coEvery { breweryDetailRepository.getBreweryDetails(TestConstants.id) } answers {
                StubFactory().datasourceBreweryDetail()
            }

            var breweryDetailState: BreweryDetailState = BreweryDetailState.Error

            assert(breweryDetailState == BreweryDetailState.Error)

            breweryDetailState = breweryDetailUseCase.getBreweryDetails(TestConstants.id)

            assert(breweryDetailState == BreweryDetailState.Success(StubFactory().breweryDetail()))
        }
    }

    @Test
    fun `Ensure getBreweryDetails returns error WHEN repository calls getBreweryDetails AND fails`() {
        runBlocking {
            every { breweryDetailMapper.toDomain(StubFactory().datasourceBreweryDetail()) } answers {
                StubFactory().breweryDetail()
            }
            coEvery { breweryDetailRepository.getBreweryDetails(TestConstants.id) } throws (Exception("Error"))

            var breweryDetailState: BreweryDetailState = BreweryDetailState.Error

            assert(breweryDetailState == BreweryDetailState.Error)

            breweryDetailState = breweryDetailUseCase.getBreweryDetails(TestConstants.id)

            assert(breweryDetailState == BreweryDetailState.Error)
        }
    }

    @Test
    fun `Ensure getDatabaseBreweryDetails returns success WHEN repository calls getDatabaseBreweryDetails`() {
        runBlocking {
            every { breweryDetailMapper.toDomain(StubFactory().datasourceBreweryDetail()) } answers {
                StubFactory().breweryDetail()
            }
            coEvery { breweryDetailRepository.getDatabaseBreweryDetails(TestConstants.id) } answers {
                StubFactory().datasourceBreweryDetail()
            }

            var breweryDetailState: BreweryDetailState = BreweryDetailState.Error

            assert(breweryDetailState == BreweryDetailState.Error)

            breweryDetailState = breweryDetailUseCase.getDatabaseBreweryDetails(TestConstants.id)

            assert(breweryDetailState == BreweryDetailState.Success(StubFactory().breweryDetail()))
        }
    }

    @Test
    fun `Ensure getDatabaseBreweryDetails returns error WHEN repository calls getDatabaseBreweryDetails AND fails`() {
        runBlocking {
            every { breweryDetailMapper.toDomain(StubFactory().datasourceBreweryDetail()) } answers {
                StubFactory().breweryDetail()
            }
            coEvery { breweryDetailRepository.getDatabaseBreweryDetails(TestConstants.id) } throws (Exception("Error"))

            var breweryDetailState: BreweryDetailState = BreweryDetailState.Error

            assert(breweryDetailState == BreweryDetailState.Error)

            breweryDetailState = breweryDetailUseCase.getDatabaseBreweryDetails(TestConstants.id)

            assert(breweryDetailState == BreweryDetailState.Error)
        }
    }

    private fun getBreweryDetailUseCase() = BreweryDetailUseCaseImpl(
        breweryDetailMapper, breweryDetailRepository
    )
}