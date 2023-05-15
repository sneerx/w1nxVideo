package com.w1nxclub.winxvideo.data.model.credits

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Credits(
    val cast: List<Cast>?,
    val director: Director?
): Parcelable