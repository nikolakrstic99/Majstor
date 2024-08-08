package com.master.app.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

object Datastore {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
}