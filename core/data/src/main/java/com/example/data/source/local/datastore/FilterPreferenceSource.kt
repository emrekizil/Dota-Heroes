package com.example.data.source.local.datastore

interface FilterPreferenceSource {
    suspend fun saveFilterPreference(filterPreference:String)
    fun getFilterPreference():String
}