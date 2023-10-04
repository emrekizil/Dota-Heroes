package com.example.domain.usecase.setsortingpreference

import com.example.domain.repository.DotaRepository
import javax.inject.Inject

class SetSortingPreferenceUseCaseImpl @Inject constructor(
    private val repository: DotaRepository
) : SetSortingPreferenceUseCase {
    override suspend fun invoke(sortingPreference: String) {
        repository.saveSortingPreference(sortingPreference)
    }
}