package com.rikiratinokua.expolerercountries.di

import com.rikiratinokua.expolerercountries.networking.service.CountiesService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration

val NetworkModule = module {
    single<CountiesService> {
        val okHttpClient = OkHttpClient.Builder()
            .writeTimeout(Duration.ofMillis(3600 * 24))
            .build()

        Retrofit.Builder()
            .baseUrl(CountiesService.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountiesService::class.java)
    }
}