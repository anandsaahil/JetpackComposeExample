package com.example.data.dataSource.user

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDataSourceFactory @Inject constructor(
    private val deviceRemoteDataSource: UserRemoteDataSource
) {
    fun retrieveDeviceListDataSource(): UserDataSource {
        return retrieveRemoteDataSource()
    }

    fun retrieveRemoteDataSource(): UserRemoteDataSource {
        return deviceRemoteDataSource
    }

//    fun retrieveCacheDataSource(): DeviceCacheDataSource {
//        return deviceCacheDataSource
//    }
}