package com.example.domain.usecase.getallheroes

import com.example.common.NetworkResponseState
import com.example.domain.entity.HeroEntity
import com.example.domain.repository.DotaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllHeroesUseCaseImpl @Inject constructor(
   private val repository: DotaRepository
) : GetAllHeroesUseCase {
    override fun invoke(): Flow<NetworkResponseState<List<HeroEntity>>> = repository.getAllHeroes()
}