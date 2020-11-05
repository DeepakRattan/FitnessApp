package com.example.fitnessapptechugo.data.apis

sealed class ApiResponse<out T> {
    data class Success<T>(val value: T) : ApiResponse<T>()
    data class Error<T>(val code: String) : ApiResponse<T>()

    val isSuccess: Boolean get() = this is ApiResponse.Success
    val isError: Boolean get() = this is ApiResponse.Error
}