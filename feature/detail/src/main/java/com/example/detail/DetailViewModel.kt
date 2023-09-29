package com.example.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.di.IoDispatcher
import com.example.domain.usecase.deletesavedhero.DeleteSavedHeroUseCase
import com.example.domain.usecase.isheroexist.IsHeroExistUseCase
import com.example.domain.usecase.savehero.SaveHeroUseCase
import com.example.ui.HeroUiData
import com.example.ui.mapper.toDomainEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val saveHeroUseCase: SaveHeroUseCase,
    private val deleteSavedHeroUseCase: DeleteSavedHeroUseCase,
    private val isHeroExistUseCase: IsHeroExistUseCase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _isHeroExistState = MutableStateFlow(false)

    val isHeroExistState = _isHeroExistState.asStateFlow()

    var innerState = false
    fun isHeroExist(heroId:Int){
        viewModelScope.launch(ioDispatcher){
            val state = isHeroExistUseCase.isHeroExist(heroId)
            _isHeroExistState.update {
                state
            }
            innerState = state
        }
    }
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

    fun setInnerState(){
        innerState = !innerState
    }

}