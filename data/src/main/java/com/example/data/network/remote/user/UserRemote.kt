package com.example.data.network.remote.user

import com.example.data.entity.UserEntity
import retrofit2.Response

interface UserRemote {
    suspend fun getAllUsers(): Response<List<UserEntity>>
}