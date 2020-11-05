package com.example.fitnessapptechugo.utils

import com.google.gson.JsonSyntaxException
import java.net.ConnectException
import java.net.UnknownHostException

fun Exception.getStatusCode(): String {
    return when (this) {
        is ConnectException -> NetworkConstants.SERVER_CONNECTION_ERROR
        is UnknownHostException -> NetworkConstants.NETWORK_NOT_AVAILABLE
        is JsonSyntaxException -> NetworkConstants.SYNTAX_ERROR
        else -> NetworkConstants.UNKNOWN_ERROR
    }
}