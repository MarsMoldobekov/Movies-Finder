package com.example.moviesearchapp.domain.data

import com.google.gson.annotations.SerializedName

data class ProductionCompany(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("logo_path") val logoPath: String?,
    @SerializedName("origin_country") val originCountry: String
)