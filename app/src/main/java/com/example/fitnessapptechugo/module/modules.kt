package com.example.fitnessapptechugo.module

import com.example.fitnessapptechugo.data.apis.Api
import com.example.fitnessapptechugo.data.repos.AppRepository
import com.example.fitnessapptechugo.ui.MainViewModel
import com.example.fitnessapptechugo.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


var appModule = module {
    single {
        createWebService<Api>(get())
    }
    single {
        okHttpClient()
    }

    viewModel {
        MainViewModel(get())
    }
    single {
        AppRepository(get())
    }
}

fun okHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(100, TimeUnit.SECONDS)
        .writeTimeout(100, TimeUnit.SECONDS)
        .readTimeout(100, TimeUnit.SECONDS)
        .addInterceptor(getHttpLoggingInterceptor())
        .build()
}

private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return httpLoggingInterceptor
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(T::class.java)
}