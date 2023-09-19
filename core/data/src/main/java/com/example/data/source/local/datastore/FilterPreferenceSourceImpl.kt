package com.example.data.source.local.datastore

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject


class FilterPreferenceSourceImpl @Inject constructor(private val dataStore: DataStore<Preferences>) :
    FilterPreferenceSource {

    override suspend fun saveAttributePreference(filterPreference: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.SELECTED_ATTRIBUTE] = filterPreference
        }
    }

    override fun getAttributePreference(): Flow<String> =
        dataStore.data.catch { exception ->
            if (exception is IOException) {
                Log.e("Error", "Error reading preferences", exception)
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            preferences[PreferencesKeys.SELECTED_ATTRIBUTE]
                ?: ""
        }

    private object PreferencesKeys {
        val SELECTED_ATTRIBUTE = stringPreferencesKey("attribute")
    }

}