package com.example.domain.usecase.deletesavedhero

import com.example.domain.entity.SavedHeroDomainEntity

interface DeleteSavedHeroUseCase {
     suspend operator fun invoke(savedHeroDomainEntity: SavedHeroDomainEntity)
}