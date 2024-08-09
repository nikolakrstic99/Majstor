package com.master.app.data.source

import android.content.Context
import android.content.SharedPreferences

object LocalStorageManager {
    private const val PREF_NAME = "LocalSharedPref"
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveString(key: String, value: String): Unit =
        sharedPreferences.edit().putString(key, value).apply()

    fun getString(key: String, defaultValue: String): String =
        sharedPreferences.getString(key, defaultValue) ?: defaultValue

    fun contains(key: String): Boolean =
        sharedPreferences.contains(key)

    fun deleteString(key: String): Unit =
        sharedPreferences.edit().remove(key).apply()
}