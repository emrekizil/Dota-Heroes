package com.example.saved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.di.IoDispatcher
import com.example.domain.usecase.deletesavedhero.DeleteSavedHeroUseCase
import com.example.domain.usecase.getsavedheroes.GetSavedHeroesUseCase
import com.example.domain.usecase.savehero.SaveHeroUseCase
import com.example.ui.HeroUiData
import com.example.ui.mapper.toDomainEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedHeroViewModel @Inject constructor(
    private val getSavedHeroesUseCase: GetSavedHeroesUseCase,
    private val deleteSavedHeroUseCase: DeleteSavedHeroUseCase,
    private val saveHeroUseCase: SaveHeroUseCase,
    private val heroUiToDomainMapperImpl: HeroUiToDomainMapperImpl,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _savedHeroUiState = MutableStateFlow<SavedHeroUiState>(SavedHeroUiState.Loading)

    val savedHeroUiState = _savedHeroUiState.asStateFlow()


    fun getSavedHeroes(heroName:String){
        viewModelScope.launch(ioDispatcher) {
            getSavedHeroesUseCase(heroName).collectLatest { value ->
                _savedHeroUiState.update {
                    SavedHeroUiState.Success(
                        heroUiToDomainMapperImpl.map(value)
                    )
                }
            }
        }
    }

    fun deleteSavedHero(heroUiData: HeroUiData){
        viewModelScope.launch(ioDispatcher) {
            deleteSavedHeroUseCase(heroUiData.toDomainEntity())
        }
    }

    fun saveHero(heroUiData: HeroUiData){
        viewModelScope.launch(ioDispatcher) {
            saveHeroUseCase(heroUiData.toDomainEntity())
        }
    }


}