package com.example.data.repository

import com.example.common.NetworkResponseState
import com.example.common.di.IoDispatcher
import com.example.data.mapper.CacheToDotaResponseListImpl
import com.example.data.mapper.DotaResponseListToCacheMapperImpl
import com.example.data.mapper.FilterHeroes
import com.example.data.mapper.HeroDbToDomainListMapperImpl
import com.example.data.mapper.HeroListMapperImpl
import com.example.data.mapper.toDatabaseEntity
import com.example.data.source.local.LocalDataSource
import com.example.data.source.local.datastore.FilterPreferenceSource
import com.example.data.source.remote.RemoteDataSource
import com.example.domain.entity.HeroEntity
import com.example.domain.entity.SavedHeroDomainEntity
import com.example.domain.repository.DotaRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DotaRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val filterPreferenceSource: FilterPreferenceSource,
    private val heroListMapperImpl: HeroListMapperImpl,
    private val localDataSource: LocalDataSource,
    private val heroDbToDomainListMapperImpl: HeroDbToDomainListMapperImpl,
    private val filterHeroes: FilterHeroes,
    private val cacheToDotaResponseListImpl: CacheToDotaResponseListImpl,
    private val dotaResponseListToCacheMapperImpl: DotaResponseListToCacheMapperImpl,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : DotaRepository {
    override fun getAllHeroes(
        heroName: String,
        heroAttribute: String?,
        sortingPref: String,
    ): Flow<NetworkResponseState<List<HeroEntity>>> =
        flow {
            emit(NetworkResponseState.Loading)
            when (val response = remoteDataSource.getAllHeroes()) {
                is NetworkResponseState.Loading -> Unit
                is NetworkResponseState.Error -> {
                    val cachedHeroes = cacheToDotaResponseListImpl.map(localDataSource.getAllCachedHeroes())
                    emit(NetworkResponseState.Success(
                        heroListMapperImpl.map(
                            filterHeroes.execute(
                                cachedHeroes,heroName,heroAttribute,sortingPref
                            )
                        )
                    ))
                }
                is NetworkResponseState.Success -> {
                    localDataSource.insertHeroes(dotaResponseListToCacheMapperImpl.map(response.result))
                    val cachedHeroes =
                        cacheToDotaResponseListImpl.map(localDataSource.getAllCachedHeroes())
                    emit(
                        NetworkResponseState.Success(
                            heroListMapperImpl.map(
                                filterHeroes.execute(
                                    cachedHeroes, heroName, heroAttribute, sortingPref
                                )
                            )
                        )
                    )
                }
            }
        }.flowOn(ioDispatcher)

    override suspend fun saveAttributePreference(attributePreference: String) {
        filterPreferenceSource.saveAttributePreference(attributePreference)
    }

    override fun getSavedHeroes(heroName: String): Flow<List<SavedHeroDomainEntity>> =
        localDataSource.getSavedHeroes().map { heroList ->
            heroDbToDomainListMapperImpl.map(heroList.filter {
                it.localizedName.lowercase().contains(heroName.lowercase())
            })
        }

    override suspend fun saveHero(savedHeroDomainEntity: SavedHeroDomainEntity) {
        localDataSource.saveHero(savedHeroDomainEntity.toDatabaseEntity())
    }

    override suspend fun deleteSavedHero(savedHeroDomainEntity: SavedHeroDomainEntity) {
        localDataSource.deleteSavedHero(savedHeroDomainEntity.toDatabaseEntity())
    }


    override fun getAttributePreference(): Flow<String> =
        filterPreferenceSource.getAttributePreference()

    override suspend fun saveSortingPreference(sortingPreference: String) {
        filterPreferenceSource.saveSortingPreference(sortingPreference)
    }

    override fun getSortingPreference(): Flow<String> =
        filterPreferenceSource.getSortingPreference()


    override suspend fun isHeroExist(heroId: Int): Boolean = localDataSource.isHeroExist(heroId)
}