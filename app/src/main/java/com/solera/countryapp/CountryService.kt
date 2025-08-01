package com.solera.countryapp

import retrofit2.Call
import retrofit2.http.GET

interface CountryService {
    @GET("countries")
    fun getContries(): Call<List<Country>>

}
