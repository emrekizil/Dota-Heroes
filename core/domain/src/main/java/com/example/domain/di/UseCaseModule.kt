package com.example.domain.di

import com.example.domain.usecase.deletesavedhero.DeleteSavedHeroUseCase
import com.example.domain.usecase.deletesavedhero.DeleteSavedHeroUseCaseImpl
import com.example.domain.usecase.getallheroes.GetAllHeroesUseCase
import com.example.domain.usecase.getallheroes.GetAllHeroesUseCaseImpl
import com.example.domain.usecase.getheroattribute.GetHeroAttributeUseCase
import com.example.domain.usecase.getheroattribute.GetHeroAttributeUseCaseImpl
import com.example.domain.usecase.getsavedheroes.GetSavedHeroesUseCase
import com.example.domain.usecase.getsavedheroes.GetSavedHeroesUseCaseImpl
import com.example.domain.usecase.isheroexist.IsHeroExistUseCase
import com.example.domain.usecase.isheroexist.IsHeroExistUseCaseImpl
import com.example.domain.usecase.savehero.SaveHeroUseCase
import com.example.domain.usecase.savehero.SaveHeroUseCaseImpl
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

    @Binds
    @ViewModelScoped
    abstract fun bindGetSavedHeroesUseCase(getSavedHeroesUseCaseImpl: GetSavedHeroesUseCaseImpl) : GetSavedHeroesUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDeleteSavedHeroUseCase(deleteSavedHeroUseCaseImpl: DeleteSavedHeroUseCaseImpl) : DeleteSavedHeroUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindSaveHeroUseCase(saveHeroUseCaseImpl: SaveHeroUseCaseImpl) : SaveHeroUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindIsHeroExistUseCase(isHeroExistUseCaseImpl: IsHeroExistUseCaseImpl):IsHeroExistUseCase
}