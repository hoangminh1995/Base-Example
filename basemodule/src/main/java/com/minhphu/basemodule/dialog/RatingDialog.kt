package com.minhphu.basemodule.dialog

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.minhphu.basemodule.R

object RatingDialog {
    fun getDialog(
        context: Context,
        onYesClick: (v: View) -> Unit,
        onNoClick: (v: View) -> Unit
    ): AlertDialog {
        val dialogBuilder = AlertDialog.Builder(context)
        val dialogView = View.inflate(context, R.layout.dialog_rating_app, null)
        dialogBuilder.setView(dialogView)
        val alertDialogRating = dialogBuilder.create()
        dialogView.findViewById<TextView>(R.id.btnRatingApp).setOnClickListener {
            onYesClick(it)
            alertDialogRating.dismiss()
        }

        dialogView.findViewById<TextView>(R.id.btnCancel).setOnClickListener {
            onNoClick(it)
            alertDialogRating.dismiss()
        }
        val back = ColorDrawable(Color.TRANSPARENT)
        val inset = InsetDrawable(back, 80)
        alertDialogRating.setCanceledOnTouchOutside(false)
        alertDialogRating.window?.setBackgroundDrawable(inset)
        return alertDialogRating
    }
}
