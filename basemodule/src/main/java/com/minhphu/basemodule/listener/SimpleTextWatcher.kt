package com.minhphu.basemodule.listener

import android.text.Editable
import android.text.TextWatcher

class SimpleTextWatcher(private val afterTextChanged: AfterTextChanged) : TextWatcher {
    interface AfterTextChanged {
        fun afterTextChanged(s: Editable)
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

    override fun afterTextChanged(s: Editable) {
        afterTextChanged.afterTextChanged(s)
    }
}