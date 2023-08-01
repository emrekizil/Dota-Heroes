package com.example.home

import android.view.ViewGroup
import com.example.home.databinding.AdapterHeroItemBinding
import com.example.ui.HomeUiData
import com.example.ui.base.BaseViewHolder
import com.example.ui.extension.inflateAdapterItem

class HeroViewHolder(private val binding: AdapterHeroItemBinding , val onClick:(HomeUiData)-> Unit) : BaseViewHolder<HomeUiData>(binding.root) {

    private var viewData:HomeUiData?=null
    companion object{
        fun createForm(parent:ViewGroup, onClick: (HomeUiData) -> Unit) =
            HeroViewHolder(
                parent.inflateAdapterItem(AdapterHeroItemBinding::inflate), onClick
            )
    }

    init {
        itemView.setOnClickListener {
            viewData?.let(onClick)
        }
    }

    override fun onBind(data: HomeUiData) {
        binding.heroComponent.setHeroData(data)
        viewData = data
    }

}