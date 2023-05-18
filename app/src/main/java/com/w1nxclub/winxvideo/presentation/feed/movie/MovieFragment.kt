package com.w1nxclub.winxvideo.presentation.feed.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.core.util.MockMovie
import com.w1nxclub.winxvideo.core.util.carouselForMovie
import com.w1nxclub.winxvideo.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : BaseFragment<FragmentMovieBinding>(
    FragmentMovieBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initCLick()
        setupCarousel()
    }

    private fun setupCarousel() {
        binding.apply {
            mainCarouselView.carouselForMovie(
                movieResult = MockMovie.mockMovieResult,
                isAutoPlay = true,
                layoutResource = R.layout.carousel_backdrop_image_item,
                imgId = R.id.ivBackdropCarousel,
                destination = R.id.action_movieFragment_to_movieDetailFragment,
                isPoster = false,
                enableSnapping = true,
                hideIndicator = false
            )
            carouselSuggestion.carouselForMovie(
                movieResult = MockMovie.mockMovieResult,
                isAutoPlay = false,
                layoutResource = R.layout.carousel_poster_item,
                imgId = R.id.ivPosterCarousel,
                destination = R.id.action_movieFragment_to_movieDetailFragment,
                isPoster = true,
                enableSnapping = false,
                hideIndicator = true
            )
        }
    }

    private fun initCLick() {
        binding.apply {
            chipTvSeries.setOnClickListener {
                findNavController().navigate(R.id.action_movieFragment_to_tvShowFragment)
            }
            chipAll.setOnClickListener {
                findNavController().navigate(R.id.action_movieFragment_to_feedFragment)
            }
            profileButton.setOnClickListener {
                findNavController().navigate(R.id.action_movieFragment_to_profileFragment)
            }
        }
    }
}