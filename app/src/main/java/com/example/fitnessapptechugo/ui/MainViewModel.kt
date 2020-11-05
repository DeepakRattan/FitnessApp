package com.example.fitnessapptechugo.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fitnessapptechugo.data.apis.ApiResponse
import com.example.fitnessapptechugo.data.models.FitnessResponse
import com.example.fitnessapptechugo.data.models.Result
import com.example.fitnessapptechugo.data.repos.AppRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val appRepository: AppRepository) : ViewModel() {
    var isSuccess = MutableLiveData<Result>()
    var isError = MutableLiveData<Boolean>()

    fun getData() {
        GlobalScope.launch {
            val res = appRepository.getFitnessData()
            when (res) {
                is ApiResponse.Success -> isSuccess.postValue(res.value?.result)
                is ApiResponse.Error -> isError.postValue(true)
            }
        }
    }

    fun getResult(): Result? {
        return isSuccess.value
    }

}