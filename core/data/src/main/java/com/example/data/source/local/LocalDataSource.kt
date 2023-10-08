package com.example.data.source.local

import com.example.data.database.entity.DotaResponseItemEntity
import com.example.data.database.entity.SavedHeroEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun saveHero(savedHeroEntity: SavedHeroEntity)

    suspend fun deleteSavedHero(savedHeroEntity: SavedHeroEntity)

    fun getSavedHeroes(): Flow<List<SavedHeroEntity>>

    suspend fun isHeroExist(heroId : Int):Boolean

    suspend fun insertHeroes(dotaResponseList:List<DotaResponseItemEntity>)

    suspend fun deleteCachedHeroes()

    fun getAllCachedHeroes():List<DotaResponseItemEntity>
}