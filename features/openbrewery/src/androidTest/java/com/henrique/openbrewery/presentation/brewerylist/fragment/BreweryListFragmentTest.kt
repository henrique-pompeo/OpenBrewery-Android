package com.henrique.openbrewery.presentation.brewerylist.fragment

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.henrique.openbrewery.infrastructure.InstrumentedTest
import com.henrique.openbrewery.R
import com.henrique.openbrewery.ui.extension.checkIsGone
import com.henrique.openbrewery.ui.extension.checkIsVisible
import com.henrique.openbrewery.presentation.brewerylist.viewmodel.BreweryListViewModel
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetailState
import com.henrique.datasource.datasource.brewerydetail.domain.model.BreweryDetail
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

@RunWith(AndroidJUnit4::class)
class BreweryListFragmentTest : InstrumentedTest() {

    private val breweryListViewModel = mockk<BreweryListViewModel>()
    private val breweryListLiveData = MutableLiveData<BreweryDetailState<List<BreweryDetail>>>()

    @Before
    fun setup() {
        startKoin {
            module{
                viewModel { breweryListViewModel }
            }
        }
    }

    @After
    fun cleanUp() {
        stopKoin()
    }

    @Test
    fun shouldShowLoadingHideContentAndLayoutErrorWhenResultStatusIsLoading() = runBlocking {
        launchFragmentInContainer<BreweryListFragment>()
        breweryListLiveData.postValue(BreweryDetailState.Loading)
        onView(withId(R.id.brewery_list_loading_pb)).checkIsVisible()
        onView(withId(R.id.brewery_list_rv)).checkIsGone()
        onView(withId(R.id.brewery_list_error_cl)).checkIsGone()
    }

    @Test
    fun shouldUpdateAndShowAdapterHideLoadingAndLayoutErrorWhenResultStatusIsSuccess() {

    }

    @Test
    fun shouldShowLayoutErrorAndUpdateErrorMessageHideContentAndLoadingWhenResultStatusIsError() {

    }

}