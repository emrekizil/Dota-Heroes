package com.example.data.source

import com.example.common.NetworkResponseState
import com.example.data.dto.DotaResponseItem

interface RemoteDataSource {

    suspend fun getAllHeroes() : NetworkResponseState<List<DotaResponseItem>>
}