package com.w1nxclub.winxvideo.presentation.search.genre.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.util.MockConstants
import com.w1nxclub.winxvideo.core.util.MockConstants.ACTION
import com.w1nxclub.winxvideo.core.util.MockConstants.ANIME
import com.w1nxclub.winxvideo.core.util.MockConstants.COMEDY
import com.w1nxclub.winxvideo.core.util.MockConstants.CRIME
import com.w1nxclub.winxvideo.core.util.MockConstants.DOCUMENTARY
import com.w1nxclub.winxvideo.core.util.MockConstants.DRAMA
import com.w1nxclub.winxvideo.core.util.MockConstants.FANTASY
import com.w1nxclub.winxvideo.core.util.MockConstants.HORROR
import com.w1nxclub.winxvideo.core.util.MockConstants.MYSTERY
import com.w1nxclub.winxvideo.core.util.MockConstants.ROMANTIC
import com.w1nxclub.winxvideo.core.util.MockConstants.SCIENCE_FICTION
import com.w1nxclub.winxvideo.core.util.MockConstants.THRILLER
import com.w1nxclub.winxvideo.core.util.MockData
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.core.util.carouselForMovie
import com.w1nxclub.winxvideo.core.util.carouselForTvShow
import com.w1nxclub.winxvideo.data.model.movie.MockMovie.mockMovieResult
import com.w1nxclub.winxvideo.databinding.FragmentGenreMovieBinding
import com.w1nxclub.winxvideo.databinding.FragmentMovieBinding
import com.w1nxclub.winxvideo.presentation.search.genre.GenreFeedFragmentArgs
import com.w1nxclub.winxvideo.presentation.search.genre.GenreFeedFragmentDirections
import com.w1nxclub.winxvideo.presentation.search.genre.tvshow.GenreTvShowFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenreMovieFragment : BaseFragment<FragmentGenreMovieBinding>(
    FragmentGenreMovieBinding::inflate
) {

    val args: GenreMovieFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carouselSetup()

        binding.apply {
            tvGenreName.text = args.type?.replaceFirstChar {
                it.uppercase()
            }
        }

        binding.profileButton.setOnClickListener{
            view.findNavController().navigate(R.id.action_genreMovieFragment_to_profileFragment)
        }
        binding.chipTvSeries.setOnClickListener{
            view.findNavController().navigate(
                GenreMovieFragmentDirections.actionGenreMovieFragmentToGenreTvShowFragment(args.type)
            )
        }
        binding.chipAll.setOnClickListener{
            view.findNavController().navigate(
                GenreMovieFragmentDirections.actionGenreMovieFragmentToGenreFeedFragment(args.type)
            )
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

        }

    }
}



