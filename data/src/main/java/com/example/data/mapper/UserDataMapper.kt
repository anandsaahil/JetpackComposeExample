package com.example.data.mapper

import com.example.data.entity.UserEntity
import com.example.domain.model.UserDomain
import javax.inject.Inject

class UserDataMapper @Inject constructor() {
    fun mapEntityToDomain(userEntity: UserEntity): UserDomain {
        return UserDomain(
            name = userEntity.name,
            thumbnailUrl = userEntity.thumbnailUrl
        )
    }

    fun mapEntityListToDomainList(idList: List<UserEntity>): List<UserDomain>{
        return idList.map {
            mapEntityToDomain(it)
        }
    }

    fun mapDomainToEntity(userDomain: UserDomain): UserEntity {
        return UserEntity(
            name = userDomain.name,
            thumbnailUrl = userDomain.thumbnailUrl
        )
    }
}