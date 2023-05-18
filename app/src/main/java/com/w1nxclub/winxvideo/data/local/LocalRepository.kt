package com.w1nxclub.winxvideo.data.local

import com.w1nxclub.winxvideo.data.model.Media
import com.w1nxclub.winxvideo.data.model.movie.Movie
import javax.inject.Inject

class LocalRepository @Inject constructor(db: WinxDatabase) {

    private val dao = db.getWinxDao()

    fun getAllMovies() = dao.getAllMovies()

    suspend fun addMovie(movie: Movie) {
        dao.insertMovie(movie)
    }

    suspend fun deleteMovie(id: Int) = dao.deleteMovie(id)

    suspend fun checkMovieExists(movieId: Int) = dao.checkMovieExists(movieId)

    private val mediaDao = db.getMediaDao()

    suspend fun insertMedia(media: Media) = mediaDao.insert(media)

    fun getAllMedia() = mediaDao.getAllMedia()

    suspend fun deleteMedia(id: Int) = mediaDao.deleteMedia(id)

    suspend fun checkMediaExists(mediaId: Int) = mediaDao.checkMediaExists(mediaId)
}