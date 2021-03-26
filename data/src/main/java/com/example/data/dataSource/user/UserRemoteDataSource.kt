package com.example.data.dataSource.user

import com.example.data.entity.UserEntity
import com.example.data.network.remote.user.UserRemote
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRemoteDataSource @Inject constructor(
    private val deviceRemote: UserRemote
) :
    UserDataSource {

    override suspend fun getAllUsers(): Response<List<UserEntity>> {
        return deviceRemote.getAllUsers()
    }
}