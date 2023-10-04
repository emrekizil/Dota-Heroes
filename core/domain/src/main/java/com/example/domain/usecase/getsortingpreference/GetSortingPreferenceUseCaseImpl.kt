package com.example.domain.usecase.getsortingpreference

import com.example.domain.repository.DotaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSortingPreferenceUseCaseImpl @Inject constructor(
    private val repository: DotaRepository
): GetSortingPreferenceUseCase {
    override fun invoke(): Flow<String> = repository.getSortingPreference()


}