package com.example.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.di.IoDispatcher
import com.example.domain.usecase.deletesavedhero.DeleteSavedHeroUseCase
import com.example.domain.usecase.savehero.SaveHeroUseCase
import com.example.ui.HeroUiData
import com.example.ui.mapper.toDomainEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val saveHeroUseCase: SaveHeroUseCase,
    private val deleteSavedHeroUseCase: DeleteSavedHeroUseCase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    fun saveHero(heroUiData: HeroUiData){
        viewModelScope.launch(ioDispatcher){
            saveHeroUseCase(heroUiData.toDomainEntity())
        }
    }
    fun deleteSavedHero(heroUiData: HeroUiData){
        viewModelScope.launch(ioDispatcher){
            deleteSavedHeroUseCase(heroUiData.toDomainEntity())
        }
    }

}