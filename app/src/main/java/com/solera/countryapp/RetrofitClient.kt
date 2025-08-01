package com.solera.countryapp

object RetrofitClient {
    private const val BASE_URL="https://www.apicountries.com/countries"
    val service:RickAndMortyService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyService::class.java)
    }
}