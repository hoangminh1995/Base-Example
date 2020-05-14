package com.minhphu.basemodule.extensions

import android.os.Build
import android.text.Html
import android.widget.TextView
import android.graphics.Typeface

fun TextView.setTextHtml(html: String) {
    text = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        else -> Html.fromHtml(html)
    }
}

fun TextView.setFont(fontPath: String) {
    val customFont = Typeface.createFromAsset(context.assets, fontPath)
    typeface = customFont
}
