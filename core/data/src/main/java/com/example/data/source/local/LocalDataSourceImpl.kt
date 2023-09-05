package com.example.data.source.local

import com.example.data.database.HeroDao
import com.example.data.database.entity.SavedHeroEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val heroDao: HeroDao
) : LocalDataSource {
    override suspend fun saveHero(savedHeroEntity: SavedHeroEntity) {
        heroDao.saveHero(savedHeroEntity)
    }

    override suspend fun deleteSavedHero(savedHeroEntity: SavedHeroEntity) {
        heroDao.deleteSavedHero(savedHeroEntity)
    }

    override fun getSavedHeroes(): Flow<List<SavedHeroEntity>>  = heroDao.getSavedHeroes()
}