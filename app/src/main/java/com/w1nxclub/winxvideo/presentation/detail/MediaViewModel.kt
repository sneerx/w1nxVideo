package com.w1nxclub.winxvideo.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.w1nxclub.winxvideo.data.local.LocalRepository
import com.w1nxclub.winxvideo.data.model.Media
import com.w1nxclub.winxvideo.data.model.movie.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MediaViewModel @Inject constructor(
    private val localRepository: LocalRepository
) : ViewModel() {

    private var _isExist = MutableLiveData<Boolean>()

    fun getSavedMedia() = localRepository.getAllMedia()

    fun insertMedia(media: Media) = viewModelScope.launch {
        _isExist.value = true
        localRepository.insertMedia(media)
    }

    fun deleteMedia(id: Int) = viewModelScope.launch {
        _isExist.value = false
        localRepository.deleteMedia(id)
    }

    suspend fun checkMediaExists(mediaId: Int): LiveData<Boolean> {

        viewModelScope.launch {
            _isExist.value = localRepository.checkMediaExists(mediaId)
        }
        return _isExist
    }

}