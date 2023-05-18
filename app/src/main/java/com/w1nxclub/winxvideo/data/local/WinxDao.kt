package com.w1nxclub.winxvideo.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.w1nxclub.winxvideo.data.model.movie.Movie

@Dao
interface WinxDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie)

    @Query("select * from movie")
    fun getAllMovies(): LiveData<List<Movie>>

    @Query("delete from movie where id =:id")
    suspend fun deleteMovie(id: Int)

    @Query("SELECT EXISTS(SELECT 1 FROM movie WHERE id = :movieId LIMIT 1)")
    suspend fun checkMovieExists(movieId: Int): Boolean
}