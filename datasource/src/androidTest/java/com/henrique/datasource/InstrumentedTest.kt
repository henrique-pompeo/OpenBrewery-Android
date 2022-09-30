package com.henrique.datasource

import androidx.test.core.app.ApplicationProvider
import com.henrique.datasource.dataprovider.providers.infrastructure.DataProvidersDI
import com.henrique.datasource.infrastructure.DatasourceDI
import org.junit.Before
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

abstract class InstrumentedTest {

    open fun onSetUp() {}

    open fun onTearDown() {}

    @Before
    fun setUp() {
        stopKoin()
        startKoin {
            androidContext(ApplicationProvider.getApplicationContext())
            modules(
                module {
                    DatasourceDI.module +
                            DataProvidersDI.module
                }
            )
        }
        onSetUp()
    }
}
