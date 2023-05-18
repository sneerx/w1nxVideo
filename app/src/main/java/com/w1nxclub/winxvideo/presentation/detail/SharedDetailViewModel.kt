package com.w1nxclub.winxvideo.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.w1nxclub.winxvideo.data.model.movie.Movie
import com.w1nxclub.winxvideo.data.model.tvshow.TvShow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class SharedDetailViewModel : ViewModel() {

    private var _movieData = MutableLiveData<Movie>()
    val movieData: LiveData<Movie> = _movieData

    private var _tvShowData = MutableLiveData<TvShow>()
    val tvShowData: LiveData<TvShow> = _tvShowData

    private var _isMovie = MutableLiveData<Boolean>()
    val isMovie: LiveData<Boolean> = _isMovie

    fun saveMovieData(movie: Movie) {
        _isMovie.value = true
        _movieData.value = movie
    }

    fun saveTvShowData(tvShow: TvShow) {
        _isMovie.value = false
        _tvShowData.value = tvShow
    }
}