package com.example.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.database.entity.DotaResponseItemEntity
import com.example.data.database.entity.SavedHeroEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HeroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveHero(savedHeroEntity: SavedHeroEntity)

    @Delete
    suspend fun deleteSavedHero(savedHeroEntity: SavedHeroEntity)

    @Query("SELECT * FROM saved_heroes ORDER BY id ASC")
    fun getSavedHeroes(): Flow<List<SavedHeroEntity>>

    @Query("SELECT EXISTS (SELECT * FROM saved_heroes WHERE id = :id)")
    suspend fun isHeroExist(id:Int) : Boolean


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroes(heroes:List<DotaResponseItemEntity>)

    @Query("DELETE FROM dota_response_item_entity")
    suspend fun deleteCachedHeroes()

    @Query("SELECT * FROM dota_response_item_entity ORDER BY id ASC")
    fun getAllCachedHeroes():List<DotaResponseItemEntity>

}