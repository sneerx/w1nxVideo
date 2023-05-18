package com.w1nxclub.winxvideo.presentation.feed.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.core.util.carouselForTvShow
import com.w1nxclub.winxvideo.data.model.tvshow.MockTvShow
import com.w1nxclub.winxvideo.databinding.FragmentMovieBinding
import com.w1nxclub.winxvideo.databinding.FragmentTvShowBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowFragment : BaseFragment<FragmentTvShowBinding>(
    FragmentTvShowBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClick()
        setupCarousel()
    }

    private fun setupCarousel() {
        binding.apply {
            mainCarouselView.carouselForTvShow(
                tvShowResult = MockTvShow.mockTvShowResult,
                isAutoPlay = true,
                layoutResource = R.layout.carousel_backdrop_image_item,
                imgId = R.id.ivBackdropCarousel,
                destination = R.id.action_tvShowFragment_to_tvShowDetailFragment,
                isPoster = false,
                enableSnapping = true,
                hideIndicator = false
            )
            carouselSuggestion.carouselForTvShow(
                tvShowResult = MockTvShow.mockTvShowResult,
                isAutoPlay = false,
                layoutResource = R.layout.carousel_poster_item,
                imgId = R.id.ivPosterCarousel,
                destination = R.id.action_tvShowFragment_to_tvShowDetailFragment,
                isPoster = true,
                enableSnapping = false,
                hideIndicator = true
            )
        }
    }

    private fun initClick() {
        binding.apply {
            chipAll.setOnClickListener {
                findNavController().navigate(R.id.action_tvShowFragment_to_feedFragment)
            }
            chipMovies.setOnClickListener {
                findNavController().navigate(R.id.action_tvShowFragment_to_movieFragment)
            }
            profileButton.setOnClickListener {
                findNavController().navigate(R.id.action_tvShowFragment_to_profileFragment)
            }
        }
    }
}