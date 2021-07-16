package com.devcomentry.moonlight.binding

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BindingViewHolder<E : Any, T : ViewDataBinding>(
    itemBinding: T,
    private val onItemClick: (E) -> Any = {},
) :
    RecyclerView.ViewHolder(itemBinding.root) {

    open fun onBind(item: E) {}
}