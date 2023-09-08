package com.example.domain.usecase.getsavedheroes

import com.example.domain.entity.SavedHeroDomainEntity
import com.example.domain.repository.DotaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedHeroesUseCaseImpl @Inject constructor(
    private val repository: DotaRepository
) : GetSavedHeroesUseCase {
    override operator fun invoke(): Flow<List<SavedHeroDomainEntity>> = repository.getSavedHeroes()
}