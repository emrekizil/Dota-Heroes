package com.example.home.di

import com.example.common.mapper.HeroListMapper
import com.example.domain.entity.HeroEntity
import com.example.home.HeroHomeUiMapperImpl
import com.example.ui.HomeUiData
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class HeroUiMapperModule {

    @Binds
    @ViewModelScoped
    abstract fun provideHeroHomeUiMapper(heroHomeUiMapperImpl: HeroHomeUiMapperImpl):HeroListMapper<HeroEntity,HomeUiData>
}