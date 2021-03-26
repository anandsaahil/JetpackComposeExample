package com.example.data.cache.preference

import android.content.Context
import android.content.SharedPreferences

open class PreferenceManager (context: Context) {

    companion object {
        private const val PREFERENCE_NAME = "com.example.users.preference"
    }

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun deleteAll() {
        preferences.clearAll()
    }

    private fun SharedPreferences.clearAll() {
        this.edit().clear().apply()
    }
}