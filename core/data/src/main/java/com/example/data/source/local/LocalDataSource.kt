package com.example.data.source.local

import com.example.data.database.entity.SavedHeroEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun saveHero(savedHeroEntity: SavedHeroEntity)

    suspend fun deleteSavedHero(savedHeroEntity: SavedHeroEntity)

    fun getSavedHeroes(): Flow<List<SavedHeroEntity>>
}