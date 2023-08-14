package com.example.ui.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.ui.HeroUiData
import com.example.ui.databinding.LayoutHeroBinding
import com.example.ui.extension.getHeroAttributeAllName
import com.example.ui.extension.getHeroPercentageAndColor
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

    fun setHeroData(heroUiData: HeroUiData){
        binding.heroImage.loadImage("https://api.opendota.com"+heroUiData.img)
        binding.heroName.text = heroUiData.localizedName
        binding.heroWinrate.getHeroPercentageAndColor(heroUiData.proWinRate)
        binding.heroAttribute.text = getHeroAttributeAllName(heroUiData.primaryAttr)
    }
}