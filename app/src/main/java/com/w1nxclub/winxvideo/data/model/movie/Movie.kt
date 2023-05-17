package com.w1nxclub.winxvideo.data.model.movie

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.w1nxclub.winxvideo.data.model.credits.Credits
import com.w1nxclub.winxvideo.data.model.genre.Genre
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val title: String?,
    val overview: String?,
    @DrawableRes val posterPath: Int?,  //TODO drawable
    @DrawableRes val backdropPath: Int?,
    val releaseDate: String?,
    val imdbRating: Float?,
    val duration: Int?,
    val genres: List<Genre>?,
    val voteAverage: Float?,
    val voteCount: Int?,
    val credits: Credits?
) : Parcelable

@Parcelize
data class MovieResult(
    val results: List<Movie>,
    val error: String? = null
) : Parcelable