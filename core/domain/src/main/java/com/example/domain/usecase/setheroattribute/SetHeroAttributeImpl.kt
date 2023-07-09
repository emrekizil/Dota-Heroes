package com.example.domain.usecase.setheroattribute

import com.example.domain.repository.DotaRepository
import javax.inject.Inject

class SetHeroAttributeImpl @Inject constructor(
    private val repository: DotaRepository
) : SetHeroAttribute {
    override suspend fun invoke(heroAttribute: String) {
        repository.saveAttributePreference(heroAttribute)
    }
}