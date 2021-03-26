package com.example.data.entity.error

data class ApiError(val message: String, @Transient val  error_description: String = "")
