package com.example.fitnessapptechugo.data.models

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("description_title") val description_title: String,
    @SerializedName("decription_image") val decription_image: String,
    @SerializedName("description_body") val description_body: String,
    @SerializedName("banner") val banner: List<String>,
    @SerializedName("latitudes") val latitudes: Double,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("cupons") val cupons: List<Cupons>
)