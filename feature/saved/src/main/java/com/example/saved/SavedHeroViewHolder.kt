package com.example.saved

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.saved.databinding.AdapterHeroItemBinding
import com.example.ui.HeroUiData
import com.example.ui.base.BaseViewHolder
import com.example.ui.extension.inflateAdapterItem

class SavedHeroViewHolder(private val binding:AdapterHeroItemBinding,private val onClick:(HeroUiData)->Unit) : BaseViewHolder<HeroUiData>(binding.root) {

    private var viewData:HeroUiData?=null

    companion object{
        fun createForm(parent:ViewGroup,onClick: (HeroUiData) -> Unit) = SavedHeroViewHolder(
            parent.inflateAdapterItem(AdapterHeroItemBinding::inflate),onClick
        )
    }

    init {
        itemView?.setOnClickListener {
            viewData?.let(onClick)
        }
    }


    override fun onBind(data: HeroUiData) {
        binding.heroComponent.setHeroData(data)
        viewData = data
    }
}