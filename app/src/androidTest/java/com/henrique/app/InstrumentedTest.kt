package com.henrique.app

import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module

abstract class InstrumentedTest {

    @Before
    fun setupTest() {
        initialize()
        loadKoinModules(getModule())
    }

    abstract fun getModule(): Module

    abstract fun initialize()

    @After
    fun tearDown() {
        unloadKoinModules(getModule())
        unmockkAll()
    }
}
