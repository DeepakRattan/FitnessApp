package com.example.fitnessapptechugo.data.repos

import com.example.fitnessapptechugo.data.apis.Api
import com.example.fitnessapptechugo.data.apis.ApiResponse
import com.example.fitnessapptechugo.data.models.FitnessResponse
import com.example.fitnessapptechugo.utils.getStatusCode
import java.lang.Exception

class AppRepository(private val api: Api) {
    suspend fun getFitnessData(): ApiResponse<FitnessResponse?> {
        return try {
            val result = api.getData()
            if (result.code() == 200 && result.body() != null) {
                ApiResponse.Success(result.body())
            } else {
                ApiResponse.Error(result.body()?.aPICODERESULT ?: "Null Response from Server")
            }
        } catch (e: Exception) {
            ApiResponse.Error(e.getStatusCode())
        }
    }
}