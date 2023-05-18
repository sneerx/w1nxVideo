package com.w1nxclub.winxvideo.data.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.w1nxclub.winxvideo.data.model.credits.Credits
import com.w1nxclub.winxvideo.data.model.genre.Genre
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "media")
data class Media(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val type: String?,
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
    val credits: Credits?,
    val numberOfSeasons: Int?,
    val numberOfEpisodes: Int?,
): Parcelable