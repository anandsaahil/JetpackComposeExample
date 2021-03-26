package com.example.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.data.BuildConfig
import com.example.data.Constants
import com.example.data.network.interceptor.AuthInterceptor
import com.example.data.network.interceptor.NetworkInterceptor
import com.example.data.network.interceptor.RedirectInterceptor
import com.example.data.network.service.UserService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RestFactory {
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        hostUrl: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(hostUrl)
            .client(okHttpClient)
            .build()

    fun provideOkHttpClient(authInterceptor: AuthInterceptor) = if (BuildConfig.DEBUG) {
        OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()

    fun provideApiService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)

    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val nw = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                //for check internet over Bluetooth
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
                else -> false
            }
        } else {
            //activeNetworkInfo & isConnected is deprecated in api 29 only.
            // But it can be used in apis below 29
            val nwInfo = connectivityManager.activeNetworkInfo ?: return false
            return nwInfo.isConnected
        }
    }
}