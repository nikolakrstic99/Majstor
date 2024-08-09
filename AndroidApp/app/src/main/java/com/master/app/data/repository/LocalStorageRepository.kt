package com.master.app.data.repository

import com.master.app.data.source.LocalStorageManager

class LocalStorageRepository {
    fun saveAuthToken(token: String): Unit = LocalStorageManager.saveString("token", token)
    fun isUserLoggedIn(): Boolean = LocalStorageManager.contains("token")
}