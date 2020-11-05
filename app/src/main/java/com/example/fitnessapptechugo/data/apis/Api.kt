package com.example.fitnessapptechugo.data.apis

import com.example.fitnessapptechugo.data.models.FitnessResponse
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("talzo/dummy/test/testing_data")
    suspend fun getData():Response<FitnessResponse>
}