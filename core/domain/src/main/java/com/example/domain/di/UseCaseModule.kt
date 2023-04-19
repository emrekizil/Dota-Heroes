package com.example.domain.di

import com.example.domain.usecase.GetAllHeroesUseCase
import com.example.domain.usecase.GetAllHeroesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Provides
    @ViewModelScoped
    abstract fun bindGetAllHeroesUseCase(getAllHeroesUseCaseImpl: GetAllHeroesUseCaseImpl): GetAllHeroesUseCase
}