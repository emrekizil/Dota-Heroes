package com.example.data.source.local.datastore

import kotlinx.coroutines.flow.Flow

interface FilterPreferenceSource {
    suspend fun saveAttributePreference(filterPreference:String)
    fun getAttributePreference(): Flow<String>

    suspend fun saveSortingPreference(sortingPreference:String)

    fun getSortingPreference():Flow<String>
}