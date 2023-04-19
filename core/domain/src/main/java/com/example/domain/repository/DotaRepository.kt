package com.example.domain.repository

import com.example.common.NetworkResponseState
import com.example.domain.entity.HeroEntity
import kotlinx.coroutines.flow.Flow

interface DotaRepository {
    fun getAllHeroes() : Flow<NetworkResponseState<List<HeroEntity>>>
}