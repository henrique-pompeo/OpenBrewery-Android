package com.henrique.openbrewery.base

import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matchers

open class BaseTestRobot {

    fun sleep(millis: Long) {
        Thread.sleep(millis)
    }

    fun clickButton(id: Int) {
        Espresso.onView(ViewMatchers.withId(id)).perform(ViewActions.click())
    }

    fun fillEditText(view: ViewInteraction, text: String) {
        view.perform(ViewActions.replaceText(text), ViewActions.closeSoftKeyboard())
    }

    fun typeEditText(view: ViewInteraction, text: String) {
        view.perform(ViewActions.typeText(text), ViewActions.closeSoftKeyboard())
    }

    fun view(id: Int): ViewInteraction = Espresso.onView(ViewMatchers.withId(id))

    fun matchText(viewInteraction: ViewInteraction, text: String) {
        viewInteraction.check(ViewAssertions.matches(ViewMatchers.withText(text)))
    }

    fun matchText(id: Int, text: String) {
        matchText(view(id), text)
    }

    fun matchTextLength(view: ViewInteraction, length: Int): ViewInteraction = view.check { v, _ ->
        Matchers.lessThanOrEqualTo((v as TextView).text.length == length)
    }

    fun matchViewEnable(id: Int) {
        view(id).check(ViewAssertions.matches(ViewMatchers.isEnabled()))
    }

    fun matchViewDisable(id: Int) {
        view(id).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isEnabled())))
    }

    fun matchViewVisible(id: Int) {
        view(id).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun matchViewInvisible(id: Int) {
        view(id).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())))
    }
}
