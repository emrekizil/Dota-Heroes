package com.example.domain.repository

import com.example.common.NetworkResponseState
import com.example.domain.entity.HeroEntity
import com.example.domain.entity.SavedHeroDomainEntity
import kotlinx.coroutines.flow.Flow

interface DotaRepository {
    fun getAllHeroes(heroName:String , heroAttribute:String?,sortingPref:String) : Flow<NetworkResponseState<List<HeroEntity>>>



    fun getSavedHeroes(heroName: String):Flow<List<SavedHeroDomainEntity>>

    suspend fun saveHero(savedHeroDomainEntity: SavedHeroDomainEntity)

    suspend fun deleteSavedHero(savedHeroDomainEntity: SavedHeroDomainEntity)

    suspend fun saveAttributePreference(attributePreference:String)
    fun getAttributePreference():Flow<String>

    suspend fun saveSortingPreference(sortingPreference:String)

    fun getSortingPreference():Flow<String>

    suspend fun isHeroExist(heroId:Int):Boolean
}