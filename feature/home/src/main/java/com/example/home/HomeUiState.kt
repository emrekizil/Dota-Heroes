package com.example.home

import androidx.annotation.StringRes
import com.example.ui.HeroUiData

sealed class HomeUiState {
    object Loading:HomeUiState()
    data class Success(val data:List<HeroUiData>): HomeUiState()
    data class Error(@StringRes val message:Int):HomeUiState()
}