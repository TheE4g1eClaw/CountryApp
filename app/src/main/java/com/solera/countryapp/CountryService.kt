package com.solera.countryapp

import retrofit2.Call
import retrofit2.http.GET

interface CountryService {
    @GET("alpha3Code")
    fun getCharacters(): Call<CountryResponse>
}