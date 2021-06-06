package com.target.targetcasestudy.util

import android.graphics.Paint
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String, progressBar: ProgressBar? = null) =
    Picasso.get()
        .load(url)
        .placeholder(android.R.color.white)
        .into(this, object : Callback {

            override fun onError(e: java.lang.Exception?) {
                e?.printStackTrace()
            }

            override fun onSuccess() {
                progressBar?.visibility = View.GONE
            }
        })

fun TextView.showStrikeThrough() {
    paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
}

fun View.showHide(isVisible: Boolean) {
    visibility = if (isVisible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}
