package com.henrique.datasource.ui.base

import androidx.lifecycle.ViewModel
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent

@KoinApiExtension
open class BaseViewModel : ViewModel(), KoinComponent