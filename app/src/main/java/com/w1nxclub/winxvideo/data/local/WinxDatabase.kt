package com.w1nxclub.winxvideo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.w1nxclub.winxvideo.data.model.Media
import com.w1nxclub.winxvideo.data.model.movie.Movie
import com.w1nxclub.winxvideo.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class, TvShow::class, Media::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class WinxDatabase: RoomDatabase() {

    abstract fun getWinxDao(): WinxDao

    abstract fun getMediaDao(): MediaDao
}