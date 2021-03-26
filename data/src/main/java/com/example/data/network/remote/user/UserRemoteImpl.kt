package com.example.data.network.remote.user

import com.example.data.entity.UserEntity
import com.example.data.network.service.UserService
import retrofit2.Response
import javax.inject.Inject

class UserRemoteImpl @Inject constructor (private val userService: UserService) : UserRemote {

    override suspend fun getAllUsers(): Response<List<UserEntity>> {
        return userService.getAllUsers()
    }
}