package com.chandra.coding.takenote.util

import android.view.View

fun View.setOnSingleClickListener(delay: Long = 500L , block: () -> Unit) {
    setOnClickListener(OnSingleClickListener(delay,block))
}