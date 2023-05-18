package com.w1nxclub.winxvideo.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.core.util.MockConstants.ACTION
import com.w1nxclub.winxvideo.core.util.MockData.movies
import com.w1nxclub.winxvideo.data.model.movie.Movie
import com.w1nxclub.winxvideo.data.model.movie.MovieResult
import com.w1nxclub.winxvideo.databinding.FragmentMovieBinding
import com.w1nxclub.winxvideo.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(
    FragmentSearchBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}