package com.example.jetpackcomposeexample.view.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.jetpackcomposeexample.utils.Resource
import com.example.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private val userRepository: UserRepository) : ViewModel() {
    val getUsers = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        Log.d("APIResult", "getUsers onLoad called")
        try {
            emit(Resource.success(data = userRepository.getAllUsers()))
            Log.d("APIResult", "getUsers onNext called")
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            Log.d("APIResult", "getUsers onError called")
        }
    }
}