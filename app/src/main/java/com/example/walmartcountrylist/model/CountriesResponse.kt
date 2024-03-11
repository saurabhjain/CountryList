package com.example.walmartcountrylist.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import com.squareup.moshi.JsonClass

@Parcelize
@JsonClass(generateAdapter = true)
data class Language(

    @Json(name = "code")
    val code: String,

    @Json(name = "name")
    val name: String,
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class CountryResponseItem(

    @Json(name = "capital")
    val capital: String,

    @Json(name = "code")
    val code: String,

    @Json(name = "flag")
    val flag: String,

    @Json(name = "name")
    val name: String,

    @Json(name = "currency")
    val currency: Currency,

    @Json(name = "language")
    val language: Language,

    @Json(name = "region")
    val region: String,
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class Currency(

    @Json(name = "symbol")
    val symbol: String,

    @Json(name = "code")
    val code: String,

    @Json(name = "name")
    val name: String,
) : Parcelable
