package com.w1nxclub.winxvideo.core.util

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun View.setVisible() {
    visibility = View.VISIBLE
}

fun View.setGone() {
    visibility = View.GONE
}

fun ImageView.downloadImage(url: Int) {     //TODO apiden sonra değişecek
//    Glide.with(context).load(url).into(this)
    Glide.with(context).asBitmap().override(1080, 600).load(url).into(this)
}