package com.solera.countryapp



data class CountryResponse(
    val CountrySearch: List<Country>
)

data class Country(
    val alpha3code : String,
    val name: String,
    val subregion: String,
    val image:String
)

