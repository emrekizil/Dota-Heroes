package com.example.data.repository

import com.example.common.NetworkResponseState
import com.example.data.dto.DotaResponseItem
import kotlinx.coroutines.flow.Flow

interface DotaRepository {
    suspend fun getAllHeroes() : Flow<NetworkResponseState<List<DotaResponseItem>>>
}