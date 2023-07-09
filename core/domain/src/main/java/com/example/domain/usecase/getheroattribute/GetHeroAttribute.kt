package com.example.domain.usecase.getheroattribute

import kotlinx.coroutines.flow.Flow

interface GetHeroAttribute {
    operator fun invoke(): Flow<String>
}