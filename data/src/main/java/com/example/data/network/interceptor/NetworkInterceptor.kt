package com.example.data.network.interceptor

import android.content.Context
import android.util.Log
import com.example.data.R
import com.example.data.network.RestFactory
import com.example.domain.error.DomainError
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor constructor(private val context: Context) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val requestBuilder = request.newBuilder()

            if (!RestFactory.isOnline(context)) {
                throw DomainError.NoInternetException("No internet connection")
            }

        return chain.proceed(requestBuilder.build())
    }

}