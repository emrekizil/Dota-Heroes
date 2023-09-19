package com.example.home.dialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.di.IoDispatcher
import com.example.domain.usecase.getheroattribute.GetHeroAttributeUseCase
import com.example.domain.usecase.setheroattribute.SetHeroAttributeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilterDialogViewModel @Inject constructor(
    private val getHeroAttributeUseCase: GetHeroAttributeUseCase,
    private val setHeroAttributeUseCase: SetHeroAttributeUseCase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
): ViewModel() {

    fun setHeroAttribute(heroAttribute:String){
        viewModelScope.launch(ioDispatcher) {
            setHeroAttributeUseCase(heroAttribute)
        }
    }

}