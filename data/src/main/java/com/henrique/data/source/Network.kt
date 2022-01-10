package com.henrique.data.source

import com.henrique.data.repository.BreweriesRepositoryImpl
import com.henrique.data.source.remote.ApiService
import com.henrique.domain.repositories.BreweriesRepository
import com.henrique.domain.usecases.GetBreweriesUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object Network {

    private const val TIME_OUT = 30L

    fun createOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        return OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor).build()
    }

    fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create()).build()
    }

    fun createService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    fun createBreweriesRepository(apiService: ApiService): BreweriesRepository {
        return BreweriesRepositoryImpl(apiService)
    }

    fun createGetBreweriesUseCase(breweriesRepository: BreweriesRepository): GetBreweriesUseCase {
        return GetBreweriesUseCase(breweriesRepository)
    }

}