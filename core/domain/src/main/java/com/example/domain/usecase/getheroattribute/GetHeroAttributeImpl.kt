package com.example.domain.usecase.getheroattribute

import com.example.domain.repository.DotaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHeroAttributeImpl @Inject constructor(
    private val repository: DotaRepository
) : GetHeroAttribute {
    override fun invoke(): Flow<String> =
        repository.getAttributePreference()
}