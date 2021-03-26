package com.example.data.cache.preference

import android.content.Context
import android.content.SharedPreferences

open class UserAuthPreference constructor(context: Context) {


    companion object {
        private const val PREFERENCE_NAME = "com.example.users.user.preference"
        private const val ACCESS_TOKEN = "access_token"
        private const val EXPIRES_IN = "expires_in"
        private const val ID_TOKEN = "id_token"
        private const val REFRESH_TOKEN = "refreshToken"
        private const val PUSH_TOKEN = "pushToken"
        private const val IS_PUSH_REGISTERED = "isPushregistered"
    }

    private val userPreferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    var idToken: String?
        get() = userPreferences.getString(ID_TOKEN, "")
        set(idToken) = userPreferences.edit().putString(ID_TOKEN, idToken).apply()

    var accessToken: String?
        get() = userPreferences.getString(ACCESS_TOKEN, "")
        set(accessToken) = userPreferences.edit().putString(ACCESS_TOKEN, accessToken).apply()

    var refreshToken: String?
        get() = userPreferences.getString(REFRESH_TOKEN, "")
        set(refreshToken) = userPreferences.edit().putString(REFRESH_TOKEN, refreshToken).apply()

    var expiresIn: Int?
        get() = userPreferences.getInt(EXPIRES_IN, 0)
        set(expiresIn) = userPreferences.edit().putInt(EXPIRES_IN, expiresIn!!).apply()

    var pushToken: String?
        get() = userPreferences.getString(PUSH_TOKEN, "")
        set(pushToken) = userPreferences.edit().putString(PUSH_TOKEN, pushToken).apply()

    var isPushregistered: Boolean
        get() = userPreferences.getBoolean(IS_PUSH_REGISTERED, false)
        set(pushToken) = userPreferences.edit().putBoolean(IS_PUSH_REGISTERED, isPushregistered).apply()


    fun deleteAll() {
        val tempPushToken = pushToken
        userPreferences.clearAll()
        pushToken = tempPushToken
    }

    private fun SharedPreferences.clearAll() {
        this.edit().clear().apply()
    }
}


