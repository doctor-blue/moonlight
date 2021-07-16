/**
 * Create by Nguyen Van Tan from Dev Comentry (07/2021)
 */
package com.devcomentry.moonlight.binding

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BindingListAdapter<E : Any, T : ViewDataBinding>(
    @LayoutRes private val layoutId: Int,
    private val callback: DiffUtil.Callback? = null,
) : RecyclerView.Adapter<BindingViewHolder<E, T>>() {
    protected var itemList: List<E> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<E, T> {
        val binding = parent.binding<T>(layoutId)
        return BindingViewHolder(itemBinding = binding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<E, T>, position: Int) {
        holder.onBind(itemList[position])

    }

    override fun getItemCount(): Int = itemList.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<E>) {
        itemList = list
        notifyDataSetChanged()
    }

}

