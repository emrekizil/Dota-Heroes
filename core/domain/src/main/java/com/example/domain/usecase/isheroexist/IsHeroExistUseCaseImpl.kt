package com.example.domain.usecase.isheroexist

import com.example.domain.repository.DotaRepository
import javax.inject.Inject


class IsHeroExistUseCaseImpl @Inject constructor(
    private val repository: DotaRepository
) : IsHeroExistUseCase {
    override suspend fun isHeroExist(heroId: Int): Boolean =
        repository.isHeroExist(heroId)

}