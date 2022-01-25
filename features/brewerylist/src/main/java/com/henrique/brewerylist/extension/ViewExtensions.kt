package com.henrique.brewerylist.extension

import android.view.View

fun View.setViewGone() {
    this.visibility = View.GONE
}

fun View.setViewInvisible() {
    this.visibility = View.INVISIBLE
}

fun View.setViewVisible() {
    visibility = View.VISIBLE
}