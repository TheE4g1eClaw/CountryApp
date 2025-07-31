package com.solera.countryapp



data class CountryResponse(
    val CountrySearch: List<Countries>
)

data class Countries(
    val alpha3code : String,
    val name: String,
    val subregion: String,
    val image:String
)

