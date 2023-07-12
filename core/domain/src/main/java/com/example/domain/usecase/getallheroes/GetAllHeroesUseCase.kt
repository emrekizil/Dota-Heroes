package com.example.domain.usecase.getallheroes

import com.example.common.NetworkResponseState
import com.example.domain.entity.HeroEntity
import kotlinx.coroutines.flow.Flow

interface GetAllHeroesUseCase {
    operator fun invoke(heroName:String,heroAttribute:String?): Flow<NetworkResponseState<List<HeroEntity>>>
}