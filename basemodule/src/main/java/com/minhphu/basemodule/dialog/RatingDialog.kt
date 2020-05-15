package com.minhphu.basemodule.dialog

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.net.Uri
import android.view.View
import android.widget.TextView
import com.minhphu.basemodule.R

object RatingDialog {
    fun show(context: Context, onYesClick: (v:View) -> Unit, onNoClick: (v:View) -> Unit) {
        val dialogBuilder = androidx.appcompat.app.AlertDialog.Builder(context)
        val dialogView = View.inflate(context, R.layout.dialog_rating_app, null)
        dialogBuilder.setView(dialogView)
        val alertDialogRating = dialogBuilder.create()
        dialogView.findViewById<TextView>(R.id.btnRatingApp).setOnClickListener {
            onYesClick(it)
        }

        dialogView.findViewById<TextView>(R.id.btnCancel).setOnClickListener {
            onNoClick(it)
        }
        val back = ColorDrawable(Color.TRANSPARENT)
        val inset = InsetDrawable(back, 80)
        alertDialogRating.setCanceledOnTouchOutside(false)
        alertDialogRating.window?.setBackgroundDrawable(inset)
        alertDialogRating.show()
    }
}
