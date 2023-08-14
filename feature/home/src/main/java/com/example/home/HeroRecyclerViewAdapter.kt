package com.example.home

import android.view.ViewGroup
import com.example.ui.HeroUiData
import com.example.ui.base.BaseRecyclerView

class HeroRecyclerViewAdapter (private val onClick: (HeroUiData) -> Unit) : BaseRecyclerView<HeroUiData,HeroViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder.createForm(parent,onClick)
    }
}