package com.rikiratinokua.expolerercountries.networking.service

import com.rikiratinokua.expolerercountries.networking.entities.Country
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CountiesService {

    @GET("all")
    suspend fun getAllCounties(): Response<List<Country>>

    @GET("name/{name}")
    suspend fun getCountriesByName(@Path("name") name: String): Response<List<Country>>

    companion object {
        const val BASE_URL = "https://restcountries.com/v3.1/"
    }
}