package com.w1nxclub.winxvideo.data.model.genre

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genre(
    val id: Int,
    val name: String?
): Parcelable