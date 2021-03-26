package com.example.data.dataSource.user
import com.example.data.entity.UserEntity
import retrofit2.Response

interface UserDataSource {
    suspend fun getAllUsers(): Response<List<UserEntity>>
}