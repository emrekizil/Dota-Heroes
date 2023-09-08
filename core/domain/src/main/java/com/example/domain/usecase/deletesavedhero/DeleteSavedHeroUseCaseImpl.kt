package com.example.domain.usecase.deletesavedhero

import com.example.domain.entity.SavedHeroDomainEntity
import com.example.domain.repository.DotaRepository
import javax.inject.Inject

class DeleteSavedHeroUseCaseImpl @Inject constructor(
    private val repository: DotaRepository
) : DeleteSavedHeroUseCase {
    override suspend operator fun invoke(savedHeroDomainEntity: SavedHeroDomainEntity) {
        repository.deleteSavedHero(savedHeroDomainEntity)
    }
}