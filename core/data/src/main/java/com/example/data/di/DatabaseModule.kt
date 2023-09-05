package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.database.HeroDao
import com.example.data.database.HeroDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideHeroDatabase(@ApplicationContext appContext:Context) : HeroDatabase {
        return Room.databaseBuilder(
            appContext,
            HeroDatabase::class.java,
            "hero_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideHeroDao(heroDatabase: HeroDatabase) : HeroDao = heroDatabase.heroDao()
}