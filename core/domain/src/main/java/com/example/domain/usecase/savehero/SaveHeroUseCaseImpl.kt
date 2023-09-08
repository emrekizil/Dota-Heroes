package com.example.domain.usecase.savehero

import com.example.domain.entity.SavedHeroDomainEntity
import com.example.domain.repository.DotaRepository
import javax.inject.Inject

class SaveHeroUseCaseImpl @Inject constructor(
    private val repository: DotaRepository
):SaveHeroUseCase {
    override suspend operator fun invoke(savedHeroDomainEntity: SavedHeroDomainEntity) {
        repository.saveHero(savedHeroDomainEntity)
    }
}