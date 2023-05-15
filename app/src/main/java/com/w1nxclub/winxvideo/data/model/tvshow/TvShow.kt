package com.w1nxclub.winxvideo.data.model.tvshow

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.w1nxclub.winxvideo.data.model.credits.Credits
import com.w1nxclub.winxvideo.data.model.genre.Genre
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShow(
    val id: Int?,
    val title: String?,
    val overview: String?,
    @DrawableRes val posterPath: Int?,
    @DrawableRes val backdropPath: Int?,
    val releaseDate: String?,
    val imdbRating: Float?,
    val genres: List<Genre>?,
    val voteAverage: Float?,
    val voteCount: Int?,
    val credits: Credits?,
    val numberOfSeasons: Int?,
    val numberOfEpisodes: Int?,
) : Parcelable