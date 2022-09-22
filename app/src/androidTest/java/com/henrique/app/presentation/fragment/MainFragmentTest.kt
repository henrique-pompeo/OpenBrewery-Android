package com.henrique.app.presentation.fragment

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.henrique.app.infrastructure.InstrumentedTest
import com.henrique.app.R
import com.henrique.app.presentation.activity.MainActivity
import com.henrique.app.presentation.extension.checkIsDisabled
import com.henrique.app.presentation.extension.checkIsEnabled
import com.henrique.app.presentation.extension.checkIsVisible
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainFragmentTest : InstrumentedTest() {

    override fun initialize() {
        ActivityScenario.launch(MainActivity::class.java)
    }
    
    @Test
    fun shouldNavigateToBreweryListPageWhenBreweryListBtIsClicked() {
        onView(withId(R.id.activity_main_brewery_list_bt)).perform(click())
        onView(withId(R.id.brewery_list_loading_pb)).checkIsVisible()
    }

    @Test
    fun shouldNavigateToBreweryDetailPageWhenBreweryDetailBtIsClicked() {
        onView(withId(R.id.activity_main_brewery_id_et)).perform(typeText("id"))
        onView(withId(R.id.activity_main_brewery_detail_bt)).perform(click())
        onView(withId(R.id.brewery_detail_loading_pb)).checkIsVisible()
    }

    @Test
    fun shouldChangeBreweryDetailBtEnablePropertyWhenBreweryIdEtTextIsChanged() {
        onView(withId(R.id.activity_main_brewery_detail_bt)).checkIsDisabled()
        onView(withId(R.id.activity_main_brewery_id_et)).perform(typeText("id"))
        onView(withId(R.id.activity_main_brewery_detail_bt)).checkIsEnabled()
    }
}