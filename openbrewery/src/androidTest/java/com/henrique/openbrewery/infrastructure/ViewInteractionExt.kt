package com.henrique.openbrewery.ui.extension

import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility

fun ViewInteraction.checkIsVisible() {
    check(ViewAssertions.matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

fun ViewInteraction.checkIsGone() {
    check(ViewAssertions.matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
}
