package com.example.domain.repository

import com.example.common.NetworkResponseState
import com.example.domain.entity.HeroEntity
import kotlinx.coroutines.flow.Flow

interface DotaRepository {
    fun getAllHeroes(heroName:String , heroAttribute:String?) : Flow<NetworkResponseState<List<HeroEntity>>>

    suspend fun saveAttributePreference(attributePreference:String)

    fun getAttributePreference():Flow<String>
}