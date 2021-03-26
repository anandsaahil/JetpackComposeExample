package com.example.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response


class RefreshTokenExpiredInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        if (response.code != 200) {
            //call event bus
            //EventBus.getDefault().post(RefreshTokenExpired())
        }
        return response
    }
}