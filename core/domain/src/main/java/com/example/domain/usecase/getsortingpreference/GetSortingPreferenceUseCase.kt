package com.example.domain.usecase.getsortingpreference

import kotlinx.coroutines.flow.Flow

interface GetSortingPreferenceUseCase {
    operator fun invoke():Flow<String>
}