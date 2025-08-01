package com.solera.countryapp

import com.google.gson.annotations.SerializedName


data class CountryResponse(
    val CountrySearch: List<Country>
)

data class Country(
    val alpha3code : String,
    val name: String,
    val subregion: String,
    val flags:Flag
)

data class Flag (
    @SerializedName("png")
    val png: String
)

