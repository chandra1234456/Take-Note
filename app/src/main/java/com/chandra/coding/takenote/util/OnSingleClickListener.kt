package com.chandra.coding.takenote.util

import android.view.View

class OnSingleClickListener(private val delay: Long , private val block: () -> Unit) : View.OnClickListener {

    private var lastClickTime = 0L

    override fun onClick(view: View) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime < delay) {
            return
        }
        lastClickTime = currentTime
        block()
    }
}