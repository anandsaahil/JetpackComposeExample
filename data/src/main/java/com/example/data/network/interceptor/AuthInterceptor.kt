package com.example.data.network.interceptor

import com.example.data.BuildConfig
import com.example.data.Constants
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val url = req.url.newBuilder().addQueryParameter("apiKey", Constants.hostUrl).build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }
}