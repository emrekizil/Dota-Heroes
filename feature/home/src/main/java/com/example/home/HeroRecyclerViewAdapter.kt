package com.example.home

import android.view.ViewGroup
import com.example.ui.HomeUiData
import com.example.ui.base.BaseRecyclerView

class HeroRecyclerViewAdapter (private val onClick: (HomeUiData) -> Unit) : BaseRecyclerView<HomeUiData,HeroViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder.createForm(parent,onClick)
    }
}