package com.example.contriesflagapi.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*



data class CountryModel( @Json(name = "name") val name: String, @Json(name = "flag") val flag : String)

data class DataArray(@Json(name = "error") val error: Boolean ,@Json(name = "msg") val msg:String,
                     @Json(name = "data") val data: List<CountryModel>
) {
}
