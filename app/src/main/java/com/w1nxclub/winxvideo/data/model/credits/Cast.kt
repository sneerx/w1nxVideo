package com.w1nxclub.winxvideo.data.model.credits

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cast(
    val id: Int,
    val name: String,
    @DrawableRes val profilePath: Int?  //TODO drawable değişecek
): Parcelable