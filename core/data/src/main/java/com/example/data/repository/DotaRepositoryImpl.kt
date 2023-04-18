package com.example.data.repository

import com.example.common.NetworkResponseState
import com.example.data.dto.DotaResponseItem
import com.example.data.source.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DotaRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : DotaRepository {
    override suspend fun getAllHeroes(): Flow<NetworkResponseState<List<DotaResponseItem>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when(val response = remoteDataSource.getAllHeroes()){
                is NetworkResponseState.Loading-> Unit
                is NetworkResponseState.Error -> emit(response)
                is NetworkResponseState.Success -> emit(
                    response // will be change
                )
            }
        }
}