package com.example.data.entity

import com.google.gson.annotations.SerializedName
import java.io.File

data class UserAddressEntity(
    @SerializedName("street")
    val street: String?,

    @SerializedName("suite")
    val suite: String?,

    @SerializedName("city")
    val city: String?,

    @SerializedName("zipcode")
    val zipCode: String?
)