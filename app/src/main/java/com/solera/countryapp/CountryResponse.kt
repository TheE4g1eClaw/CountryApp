package com.solera.countryapp

import com.google.gson.annotations.SerializedName

data class Country(
    val alpha3code : String,
    val name: String,
    val subregion: String,
    val flags:Flag,
    val capital: String,
    val population: Int,
    val numericCode: Int,
    val languages: List<Languages>,
    val independent: Boolean
)

data class Flag (
    @SerializedName("png")
    val png: String
)
data class Languages(
val name: String
)

