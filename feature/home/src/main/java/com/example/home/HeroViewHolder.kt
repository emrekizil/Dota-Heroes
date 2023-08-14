package com.example.home

import android.view.ViewGroup
import com.example.home.databinding.AdapterHeroItemBinding
import com.example.ui.HeroUiData
import com.example.ui.base.BaseViewHolder
import com.example.ui.extension.inflateAdapterItem

class HeroViewHolder(private val binding: AdapterHeroItemBinding , val onClick:(HeroUiData)-> Unit) : BaseViewHolder<HeroUiData>(binding.root) {

    private var viewData:HeroUiData?=null
    companion object{
        fun createForm(parent:ViewGroup, onClick: (HeroUiData) -> Unit) =
            HeroViewHolder(
                parent.inflateAdapterItem(AdapterHeroItemBinding::inflate), onClick
            )
    }

    init {
        itemView.setOnClickListener {
            viewData?.let(onClick)
        }
    }

    override fun onBind(data: HeroUiData) {
        binding.heroComponent.setHeroData(data)
        viewData = data
    }

}