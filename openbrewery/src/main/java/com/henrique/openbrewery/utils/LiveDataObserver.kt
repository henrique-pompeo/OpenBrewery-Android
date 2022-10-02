package com.henrique.openbrewery.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

class LiveDataObserver {
    inline fun <reified T > LiveData<T>.captureValues(): List<T?> {
        //TODO -- COULD BE USED IN FUTURE
//        val mockObserver = mockk<Observer<T>>()
        val list = mutableListOf<T?>()
//        every { mockObserver.onChanged(captureNullable(list))} just runs
//        this.observeForever(mockObserver)
        return list
    }
}