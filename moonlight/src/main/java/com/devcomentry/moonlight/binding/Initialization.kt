/**
 * Create by Nguyen Van Tan from Dev Comentry (07/2021)
 */
package com.devcomentry.moonlight.binding

import android.os.Bundle

internal interface Initialization {
    /**
     * override this function and fetch data or init variables at here.
     * This function called at onCreate() (Activity) and onCreateView() (Fragment).
     */
    fun initControls(savedInstanceState: Bundle?) {}

    /**
     * override this function and set on click, long click, view event ... at here.
     * This function called at onCreate() (Activity) and onCreateView() (Fragment).
     */
    fun initEvents() {}
}