/**
 * Create by Nguyen Van Tan from Dev Comentry (07/2021)
 */
package com.devcomentry.moonlight.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object RecyclerViewBinding {

    @JvmStatic
    @BindingAdapter("adapter")
    fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        view.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("submitList")
    fun bindSubmitList(view: RecyclerView, itemList: List<Any>?) {
        view.adapter.ifNotNull<BindingListAdapter<Any, *>> { adapter ->
            itemList?.let {
                adapter.submitList(it)
            }
        }
    }

}
