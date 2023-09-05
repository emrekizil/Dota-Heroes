package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.database.entity.SavedHeroEntity

@Database(entities = [SavedHeroEntity::class], exportSchema = false, version = 1)
abstract class HeroDatabase : RoomDatabase() {
    abstract fun heroDao() : HeroDao
}