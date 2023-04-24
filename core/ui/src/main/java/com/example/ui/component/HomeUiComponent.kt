package com.example.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.ui.HomeUiData
import com.example.ui.databinding.LayoutHeroBinding
import com.example.ui.extension.loadImage

class HomeUiComponent @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet?=null,
    defStyleAttr:Int = 0
) : FrameLayout(context,attributeSet,defStyleAttr){
    private val binding = LayoutHeroBinding.inflate(LayoutInflater.from(context),this,false)

    init {
        addView(binding.root)
    }

    fun setHeroData(homeUiData: HomeUiData){
        binding.heroImage.loadImage(homeUiData.img)
        binding.heroName.text = homeUiData.localizedName
    }
}