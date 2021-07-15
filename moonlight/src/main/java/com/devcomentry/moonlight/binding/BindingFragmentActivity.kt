/**
 * Create by Nguyen Van Tan from Dev Comentry (07/2021)
 */
package com.devcomentry.moonlight.binding

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity

class BindingFragmentActivity<T : ViewDataBinding> constructor(
    @LayoutRes val layoutId: Int
) : FragmentActivity(), Initialization {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initControls(savedInstanceState)
        initEvents()
    }

    /**
     * [DataBindingComponent] is generated during compilation
     */
    protected var bindingComponent: DataBindingComponent? = DataBindingUtil.getDefaultComponent()

    @BindingOnly
    protected val binding: T by lazy(LazyThreadSafetyMode.NONE) {
        DataBindingUtil.setContentView(this, layoutId, bindingComponent)
    }


    @BindingOnly
    protected inline fun binding(block: T.() -> Unit): T {
        return binding.apply(block)
    }

    /**
     * Ensures the [binding] property should be executed before being called [onCreate].
     */
    init {
        addOnContextAvailableListener {
            binding.notifyChange()
        }
    }

    /**
     * Unbind
     */
    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }}