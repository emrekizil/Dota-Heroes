package com.example.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.NetworkResponseState
import com.example.common.di.IoDispatcher
import com.example.common.mapper.HeroListMapper
import com.example.domain.entity.HeroEntity
import com.example.domain.usecase.getallheroes.GetAllHeroesUseCase
import com.example.ui.HomeUiData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.ui.R as coreUiRes

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllHeroesUseCase: GetAllHeroesUseCase,
    private val heroListMapper: HeroListMapper<HeroEntity,HomeUiData>,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _heroHomeUiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)

    val heroHomeUiState = _heroHomeUiState.asStateFlow()

    var heroName:String = ""

    var heroAttribute:String? = null


    fun getAllHero(){
        viewModelScope.launch(ioDispatcher) {
            getAllHeroesUseCase(heroName,heroAttribute).collectLatest {value->
                when(value){
                    is NetworkResponseState.Loading ->{
                        _heroHomeUiState.update {
                            HomeUiState.Loading
                        }
                    }
                    is NetworkResponseState.Success->{
                        _heroHomeUiState.update {
                            HomeUiState.Success(heroListMapper.map(
                                value.result
                            ))
                        }
                    }
                    is NetworkResponseState.Error ->{
                        _heroHomeUiState.update {
                            HomeUiState.Error(
                                coreUiRes.string.error
                            )
                        }
                    }
                }
            }
        }
    }

}