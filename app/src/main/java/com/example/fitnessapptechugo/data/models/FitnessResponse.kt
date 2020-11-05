package com.example.fitnessapptechugo.data.models

import com.example.fitnessapptechugo.data.models.Result
import com.google.gson.annotations.SerializedName

data class FitnessResponse(
    @SerializedName("statusCode") val statusCode: Int,
    @SerializedName("APICODERESULT") val aPICODERESULT: String,
    @SerializedName("result") val result: Result
)