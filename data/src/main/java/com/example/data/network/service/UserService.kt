package com.example.data.network.service

import com.example.data.entity.UserEntity
//import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("users")
    suspend fun getAllUsers(): Response<List<UserEntity>>
}