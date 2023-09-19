package com.example.domain.usecase.getsavedheroes

import com.example.domain.entity.SavedHeroDomainEntity
import kotlinx.coroutines.flow.Flow

interface GetSavedHeroesUseCase {

    operator fun invoke(heroName:String):Flow<List<SavedHeroDomainEntity>>
}