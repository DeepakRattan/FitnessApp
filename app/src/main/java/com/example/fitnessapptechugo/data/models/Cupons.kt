package com.example.fitnessapptechugo.data.models

import com.google.gson.annotations.SerializedName

data class Cupons(
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("price") val price: Int
)