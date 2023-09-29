package com.example.domain.usecase.isheroexist

interface IsHeroExistUseCase {

    suspend fun isHeroExist(heroId:Int):Boolean
}