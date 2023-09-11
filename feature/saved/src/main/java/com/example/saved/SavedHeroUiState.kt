package com.example.saved

import androidx.annotation.StringRes
import com.example.ui.HeroUiData

sealed class SavedHeroUiState {
    object Loading : SavedHeroUiState()
    data class Success(val data:List<HeroUiData>) : SavedHeroUiState()
    data class Error(@StringRes val message:Int) : SavedHeroUiState()
}