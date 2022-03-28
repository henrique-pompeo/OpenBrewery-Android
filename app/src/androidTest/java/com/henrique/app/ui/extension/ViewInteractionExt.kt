package com.henrique.app.ui.extension

import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import org.hamcrest.Matchers.not

fun ViewInteraction.checkIsVisible() {
    check(ViewAssertions.matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

fun ViewInteraction.checkIsGone() {
    check(ViewAssertions.matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
}

fun ViewInteraction.checkIsEnabled() {
    check(ViewAssertions.matches(ViewMatchers.isEnabled()))
}

fun ViewInteraction.checkIsDisabled() {
    check(ViewAssertions.matches(not(ViewMatchers.isEnabled())))
}
