package com.example.domain.usecase.setheroattribute

interface SetHeroAttribute {
    suspend operator fun invoke(heroAttribute:String)
}