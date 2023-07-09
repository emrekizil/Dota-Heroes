package com.example.domain.usecase.getheroattribute

import kotlinx.coroutines.flow.Flow

interface GetHeroAttributeUseCase {
    operator fun invoke(): Flow<String>
}