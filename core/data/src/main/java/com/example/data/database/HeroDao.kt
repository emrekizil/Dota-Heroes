package com.example.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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

}