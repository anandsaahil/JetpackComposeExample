package com.example.data.repository

import com.example.data.network.remote.user.UserRemote
import javax.inject.Inject

class UserRepository @Inject constructor(private val userRemote: UserRemote) {
    suspend fun getAllUsers() = userRemote.getAllUsers()
}