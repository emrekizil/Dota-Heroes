package com.example.domain.usecase.setheroattribute

import com.example.domain.repository.DotaRepository
import javax.inject.Inject

class SetHeroAttributeUseCaseImpl @Inject constructor(
    private val repository: DotaRepository
) : SetHeroAttributeUseCase {
    override suspend fun invoke(heroAttribute: String) {
        repository.saveAttributePreference(heroAttribute)
    }
}