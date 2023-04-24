package com.example.home

import androidx.annotation.StringRes
import com.example.ui.HomeUiData

sealed class HomeUiState {
    object Loading:HomeUiState()
    data class Success(val data:List<HomeUiData>): HomeUiState()
    data class Error(@StringRes val message:Int):HomeUiState()
}