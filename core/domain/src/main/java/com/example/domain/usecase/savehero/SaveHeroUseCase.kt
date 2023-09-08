package com.example.domain.usecase.savehero

import com.example.domain.entity.SavedHeroDomainEntity

interface SaveHeroUseCase {
    suspend operator fun invoke(savedHeroDomainEntity: SavedHeroDomainEntity)
}