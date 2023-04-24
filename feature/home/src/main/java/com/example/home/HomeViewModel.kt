package com.example.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.NetworkResponseState
import com.example.common.di.IoDispatcher
import com.example.common.mapper.HeroListMapper
import com.example.domain.entity.HeroEntity
import com.example.domain.usecase.GetAllHeroesUseCase
import com.example.ui.HomeUiData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.ui.R as coreUiRes

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllHeroesUseCase: GetAllHeroesUseCase,
    private val heroListMapper: HeroListMapper<HeroEntity,HomeUiData>,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _heroHomeUiState = MutableLiveData<HomeUiState>()
    val heroHomeUiState :LiveData<HomeUiState> get() = _heroHomeUiState


    fun getAllHero(){
        viewModelScope.launch(ioDispatcher) {
            getAllHeroesUseCase().collectLatest {
                when(it){
                    is NetworkResponseState.Loading ->{
                        _heroHomeUiState.postValue(HomeUiState.Loading)
                    }
                    is NetworkResponseState.Success->{
                        _heroHomeUiState.postValue(HomeUiState.Success(heroListMapper.map(it.result)))
                    }
                    is NetworkResponseState.Error ->{
                        _heroHomeUiState.postValue(HomeUiState.Error(coreUiRes.string.error))
                    }
                }
            }
        }
    }

}