package com.henrique.datasource.util

import io.mockk.clearAllMocks
import io.mockk.mockk
import org.junit.After
import org.koin.android.ext.koin.androidContext
import org.koin.android.java.KoinAndroidApplication
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module

abstract class UnitTest {

    fun setup(modules : Module) {
        clearAllMocks()
        startKoin {
            KoinAndroidApplication.create(mockk(relaxed = true))
            androidContext(mockk(relaxed = true))
        }
        loadKoinModules(modules)
    }

    @After
    fun tearDown() {
        stopKoin()
    }
}
