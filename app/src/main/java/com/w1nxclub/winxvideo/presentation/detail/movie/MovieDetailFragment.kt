package com.w1nxclub.winxvideo.presentation.detail.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.core.util.MockData.movies
import com.w1nxclub.winxvideo.core.util.downloadImage
import com.w1nxclub.winxvideo.data.model.movie.Movie
import com.w1nxclub.winxvideo.data.model.movie.MovieResult
import com.w1nxclub.winxvideo.databinding.FragmentMovieDetailBinding
import com.w1nxclub.winxvideo.presentation.detail.SharedDetailViewModel
import com.w1nxclub.winxvideo.presentation.detail.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding>(
    FragmentMovieDetailBinding::inflate
) {

    private val args: MovieDetailFragmentArgs by navArgs()
    private val sharedDetailViewModel: SharedDetailViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sendData(sharedDetailViewModel)

        getMovieDetail()
        setupViewPager()

    }

    private fun sendData(viewModel: SharedDetailViewModel) {
        args.moviearg?.let { viewModel.saveMovieData(it) }
    }
    private fun getMovieDetail() {
        binding.apply {
            args.moviearg?.let { movie ->
                movie.backdropPath?.let { ivMovieBackground.downloadImage(it) }
                tvMovieName.text = movie.title
                tvOverview.text = movie.overview
                val genre = movie.genres?.joinToString(", ") { it.name.toString() }
                tvGenres.text = genre
                tvImdbRating.text = "IMDb ${movie.imdbRating}"
                tvReleaseYear.text = movie.releaseDate
                tvDuration.text = "${movie.duration} Dk"
            }
        }
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(requireParentFragment())
        binding.apply {
            viewPager2.isUserInputEnabled = false
            viewPager2.adapter = adapter

            TabLayoutMediator(tabLayout, viewPager2){ tab, position ->
                when (position) {
                    0 -> tab.text = "İlgili"
                    1 -> tab.text = "Daha fazla ayrıntı"
                }
            }.attach()
        }
    }


}