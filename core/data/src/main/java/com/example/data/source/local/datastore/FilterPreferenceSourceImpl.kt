package com.example.data.source.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "hero_preferences")

class FilterPreferenceSourceImpl : FilterPreferenceSource {


    override suspend fun saveFilterPreference(filterPreference: String) {
        TODO("Not yet implemented")
    }

    override fun getFilterPreference(): String {
        TODO("Not yet implemented")
    }
}