package com.example.data.network.interceptor


import android.util.Log
import com.example.data.Constants
import com.example.data.cache.preference.UserAuthPreference
import okhttp3.Interceptor
import okhttp3.Response
import javax.net.ssl.SSLPeerUnverifiedException

class RefreshTokenInterceptor (private val userAuthPreference: UserAuthPreference) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        var response : Response ?= null
        try {
            val request = chain.request()
             response = chain.proceed(request)
            if (response.code == 401) {

//                val body = RestFactory.retrofit2.create(RefreshService::class.java).refreshToken(userAuthPreference.refreshToken!!).execute().body()
//                body?.let {
//                    userAuthPreference.accessToken = it.accessToken
//                    userAuthPreference.idToken = it.idToken
//                    userAuthPreference.expiresIn = it.expiresIn
//                    userAuthPreference.refreshToken = it.refreshToken
//                }

                val newRequest = response.request.newBuilder()
                        .header("Authorization", "${Constants.httpHeaderBearerTokenPrefix} " +
                                "${userAuthPreference.accessToken}")
                        .build()

                return chain.proceed(newRequest)
            }

        }catch (ee : SSLPeerUnverifiedException){
            Log.d("Exception ::" , "here....")
        }
        return response!!
    }


}
