package com.example.domain.usecase.getheroattribute

import com.example.domain.repository.DotaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHeroAttributeUseCaseImpl @Inject constructor(
    private val repository: DotaRepository
) : GetHeroAttributeUseCase {
    override fun invoke(): Flow<String> =
        repository.getAttributePreference()
}