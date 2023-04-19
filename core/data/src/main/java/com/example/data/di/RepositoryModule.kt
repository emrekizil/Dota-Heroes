package com.example.data.di

import com.example.data.repository.DotaRepositoryImpl
import com.example.domain.repository.DotaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindDotaRepository(dotaRepositoryImpl: DotaRepositoryImpl):DotaRepository
}