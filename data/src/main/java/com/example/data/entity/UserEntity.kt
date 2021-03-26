package com.example.data.entity

import com.google.gson.annotations.SerializedName

data class UserEntity(
    @SerializedName("name")
    val name: String?,

    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String?
)