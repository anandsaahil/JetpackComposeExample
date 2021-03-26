package com.example.data.network.interceptor

import com.example.data.Constants
import com.example.data.cache.preference.UserAuthPreference
import okhttp3.Interceptor
import okhttp3.Response

class BasicAuthInterceptor constructor(private val userAuthPreference: UserAuthPreference) : Interceptor {


    private val accessToken: String?
        get() = userAuthPreference.accessToken


    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()

        val requestBuilder = request.newBuilder()
        if (request.header(Constants.httpHeaderBasicTokenPrefix) != null) {
            requestBuilder
                    .removeHeader(Constants.httpHeaderBasicTokenPrefix)
                    .addHeader("Authorization",
                            "${Constants.httpHeaderBasicTokenPrefix} " +
                                    Constants.httpClientSecretHash)
                    .build()
        } else {
            requestBuilder
                    .addHeader("Authorization", "${Constants.httpHeaderBearerTokenPrefix} " +
                            "$accessToken")
                    .build()

        }



        return chain.proceed(requestBuilder.build())

    }

}

