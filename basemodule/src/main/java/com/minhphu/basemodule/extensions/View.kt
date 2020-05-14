package com.minhphu.basemodule.extensions

import android.view.View
import com.minhphu.basemodule.listener.DebouncedOnClickListener

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

const val MINIMUM_INTERVAL_CLICK_TIME = 300L

fun View.setSingleClick(onClick: (v:View) -> Unit){
    setOnClickListener(object : DebouncedOnClickListener(MINIMUM_INTERVAL_CLICK_TIME) {
        override fun onDebouncedClick(v: View) {
            onClick(v)
        }
    })
}
