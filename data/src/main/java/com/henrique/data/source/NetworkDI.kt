package com.henrique.data.source

import com.henrique.data.source.Network.createOkHttpClient
import com.henrique.data.source.Network.createRetrofit
import com.henrique.data.source.Network.createService
import com.squareup.moshi.Moshi
import org.koin.dsl.module
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkDI {

    val module = module {

        single { createService(get()) }

        single { createRetrofit(get(), get()) }

        single { createOkHttpClient() }

        single { MoshiConverterFactory.create() }

        single { Moshi.Builder().build() }

    }

}