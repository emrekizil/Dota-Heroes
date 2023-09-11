package com.example.saved

import android.view.ViewGroup
import com.example.ui.HeroUiData
import com.example.ui.base.BaseRecyclerView

class SavedHeroRecyclerViewAdapter (private val onClick:(HeroUiData)->Unit):BaseRecyclerView<HeroUiData,SavedHeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedHeroViewHolder {
        return SavedHeroViewHolder.createForm(parent,onClick)
    }
}