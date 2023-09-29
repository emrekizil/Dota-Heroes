package com.example.domain.repository

import com.example.common.NetworkResponseState
import com.example.domain.entity.HeroEntity
import com.example.domain.entity.SavedHeroDomainEntity
import kotlinx.coroutines.flow.Flow

interface DotaRepository {
    fun getAllHeroes(heroName:String , heroAttribute:String?) : Flow<NetworkResponseState<List<HeroEntity>>>

    suspend fun saveAttributePreference(attributePreference:String)

    fun getSavedHeroes(heroName: String):Flow<List<SavedHeroDomainEntity>>

    suspend fun saveHero(savedHeroDomainEntity: SavedHeroDomainEntity)

    suspend fun deleteSavedHero(savedHeroDomainEntity: SavedHeroDomainEntity)
    fun getAttributePreference():Flow<String>

    suspend fun isHeroExist(heroId:Int):Boolean
}