package com.example.domain.usecase.setheroattribute

interface SetHeroAttributeUseCase {
    suspend operator fun invoke(heroAttribute:String)
}