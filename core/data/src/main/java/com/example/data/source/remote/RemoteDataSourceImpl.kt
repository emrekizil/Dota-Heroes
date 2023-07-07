package com.example.data.source.remote

import com.example.common.NetworkResponseState
import com.example.data.api.DotaApi
import com.example.data.dto.DotaResponseItem
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val dotaApi: DotaApi
) : RemoteDataSource {

    override suspend fun getAllHeroes(): NetworkResponseState<List<DotaResponseItem>> =
        try {
            val response = dotaApi.getAllHeroes()
            NetworkResponseState.Success(response)
        }catch (e:Exception){
            NetworkResponseState.Error(e)
        }
}