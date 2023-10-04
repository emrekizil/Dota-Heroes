package com.example.domain.usecase.setsortingpreference

interface SetSortingPreferenceUseCase {

    suspend operator fun invoke(sortingPreference:String)

}