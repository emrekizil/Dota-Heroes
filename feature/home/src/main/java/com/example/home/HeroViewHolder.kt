package com.example.home

import android.view.ViewGroup
import com.example.home.databinding.AdapterHeroItemBinding
import com.example.ui.HomeUiData
import com.example.ui.base.BaseViewHolder
import com.example.ui.extension.inflateAdapterItem

class HeroViewHolder(private val binding: AdapterHeroItemBinding) : BaseViewHolder<HomeUiData>(binding.root) {

    companion object{
        fun createForm(parent:ViewGroup) =
            HeroViewHolder(
                parent.inflateAdapterItem(AdapterHeroItemBinding::inflate)
            )
    }

    override fun onBind(data: HomeUiData) {
        binding.heroComponent.setHeroData(data)
    }

}