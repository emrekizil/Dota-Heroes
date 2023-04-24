package com.example.ui.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerView <T:Any,VH:BaseViewHolder<T>> :RecyclerView.Adapter<VH>() {
    private val items = mutableListOf<T>()

    fun updateItems(newItems:List<T>){
        items.apply {
            clear()
            addAll(newItems)
            notifyDataSetChanged()
        }
    }

    fun getItem(position:Int) = items[position]

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(items[position])
    }

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH
}