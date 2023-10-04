package com.example.home.dialog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.di.IoDispatcher
import com.example.domain.usecase.setheroattribute.SetHeroAttributeUseCase
import com.example.domain.usecase.setsortingpreference.SetSortingPreferenceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilterDialogViewModel @Inject constructor(
    private val setHeroAttributeUseCase: SetHeroAttributeUseCase,
    private val setSortingPreferenceUseCase: SetSortingPreferenceUseCase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
): ViewModel() {

    fun setHeroAttribute(heroAttribute:String){
        viewModelScope.launch(ioDispatcher) {
            setHeroAttributeUseCase(heroAttribute)
        }
    }

    fun setSortingPreference(sortingPreference:String){
        viewModelScope.launch(ioDispatcher) {
            setSortingPreferenceUseCase(sortingPreference)
        }
    }

}