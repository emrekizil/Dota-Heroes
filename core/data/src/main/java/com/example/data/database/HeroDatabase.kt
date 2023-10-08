package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.data.database.entity.DotaResponseItemEntity
import com.example.data.database.entity.SavedHeroEntity
import com.example.data.database.util.StringListTypeConverter

@Database(entities = [SavedHeroEntity::class,DotaResponseItemEntity::class], exportSchema = false, version = 3)
@TypeConverters(StringListTypeConverter::class)
abstract class HeroDatabase : RoomDatabase() {
    abstract fun heroDao() : HeroDao
}