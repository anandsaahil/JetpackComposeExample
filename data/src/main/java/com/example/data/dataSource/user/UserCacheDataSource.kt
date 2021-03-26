package com.example.data.dataSource.user
import com.example.data.entity.UserEntity
import io.reactivex.Observable
import retrofit2.Response

class UserCacheDataSource (): UserDataSource {
    override suspend fun getAllUsers(): Response<List<UserEntity>> {
        TODO("Not yet implemented")
    }
}