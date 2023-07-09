package com.example.domain.di

import com.example.domain.usecase.getallheroes.GetAllHeroesUseCase
import com.example.domain.usecase.getallheroes.GetAllHeroesUseCaseImpl
import com.example.domain.usecase.getheroattribute.GetHeroAttributeUseCase
import com.example.domain.usecase.getheroattribute.GetHeroAttributeUseCaseImpl
import com.example.domain.usecase.setheroattribute.SetHeroAttributeUseCase
import com.example.domain.usecase.setheroattribute.SetHeroAttributeUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllHeroesUseCase(getAllHeroesUseCaseImpl: GetAllHeroesUseCaseImpl): GetAllHeroesUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetHeroAttributeUseCase(getHeroAttributeUseCaseImpl: GetHeroAttributeUseCaseImpl):GetHeroAttributeUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindSetHeroAttributeUseCase(setHeroAttributeUseCaseImpl: SetHeroAttributeUseCaseImpl):SetHeroAttributeUseCase
}