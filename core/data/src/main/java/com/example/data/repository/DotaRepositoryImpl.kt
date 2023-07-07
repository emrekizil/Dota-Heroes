package com.example.data.repository

import com.example.common.NetworkResponseState
import com.example.common.di.IoDispatcher
import com.example.data.mapper.HeroListMapperImpl
import com.example.data.source.remote.RemoteDataSource
import com.example.domain.entity.HeroEntity
import com.example.domain.repository.DotaRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DotaRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val heroListMapperImpl: HeroListMapperImpl,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : DotaRepository {
    override fun getAllHeroes(): Flow<NetworkResponseState<List<HeroEntity>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when(val response = remoteDataSource.getAllHeroes()){
                is NetworkResponseState.Loading-> Unit
                is NetworkResponseState.Error -> emit(response)
                is NetworkResponseState.Success -> emit(
                   NetworkResponseState.Success(heroListMapperImpl.map(response.result))
                )
            }
        }.flowOn(ioDispatcher)
}