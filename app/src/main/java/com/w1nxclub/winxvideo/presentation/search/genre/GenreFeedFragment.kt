package com.w1nxclub.winxvideo.presentation.search.genre

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.util.MockConstants.ANIME
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.core.util.carouselForMovie
import com.w1nxclub.winxvideo.core.util.carouselForTvShow
import com.w1nxclub.winxvideo.data.model.movie.MockMovie.mockMovieResult
import com.w1nxclub.winxvideo.data.model.tvshow.MockTvShow.mockTvShowResult
import com.w1nxclub.winxvideo.databinding.FragmentGenreFeedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenreFeedFragment() : BaseFragment<FragmentGenreFeedBinding>(
    FragmentGenreFeedBinding::inflate
) {
    private val args: GenreFeedFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carouselSetup()

        binding.tvGenreName.text = args.type?.replaceFirstChar {
            it.uppercase()
        }


        binding.profileButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_genreFeedFragment_to_profileFragment)
        }

        binding.chipMovies.setOnClickListener {
            view.findNavController().navigate(
                GenreFeedFragmentDirections.actionGenreFeedFragmentToGenreMovieFragment(args.type)
            )
        }
        binding.chipTvSeries.setOnClickListener {
            view.findNavController().navigate(R.id.action_genreFeedFragment_to_genreTvShowFragment)
        }


    }

    private fun carouselSetup() {
        binding.apply {

            carouselMovie.carouselForMovie(
                mockMovieResult,
                isAutoPlay = true,
                layoutResource = R.layout.carousel_item,
                imgId = R.id.imgCarousel,
                destination = R.id.action_genreFeedFragment_to_movieDetailFragment,
                isPoster = true,
                enableSnapping = false,
                hideIndicator = true
            )

            carouselPrimeTV.carouselForTvShow(
                mockTvShowResult,
                isAutoPlay = false,
                layoutResource = R.layout.carousel_item,
                imgId = R.id.imgCarousel,
                destination = R.id.action_genreFeedFragment_to_tvShowDetailFragment,
                isPoster = true,
                enableSnapping = false,
                hideIndicator = true
            )

            carouselMostWatchedMovie.carouselForMovie(
                mockMovieResult,
                isAutoPlay = false,
                layoutResource = R.layout.carousel_item,
                imgId = R.id.imgCarousel,
                destination = R.id.action_genreFeedFragment_to_movieDetailFragment,
                isPoster = true,
                enableSnapping = false,
                hideIndicator = true
            )

            carouselMostWatchedTv.carouselForTvShow(
                mockTvShowResult,
                isAutoPlay = false,
                layoutResource = R.layout.carousel_item,
                imgId = R.id.imgCarousel,
                destination = R.id.action_genreFeedFragment_to_tvShowDetailFragment,
                isPoster = true,
                enableSnapping = false,
                hideIndicator = true
            )
        }
    }

}




