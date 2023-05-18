package com.w1nxclub.winxvideo.presentation.search.genre.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.util.MockConstants
import com.w1nxclub.winxvideo.core.util.MockData
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.core.util.carouselForMovie
import com.w1nxclub.winxvideo.core.util.carouselForTvShow
import com.w1nxclub.winxvideo.data.model.tvshow.MockTvShow.mockTvShowResult
import com.w1nxclub.winxvideo.databinding.FragmentGenreTvShowBinding
import com.w1nxclub.winxvideo.databinding.FragmentMovieBinding
import com.w1nxclub.winxvideo.presentation.search.genre.GenreFeedFragmentArgs
import com.w1nxclub.winxvideo.presentation.search.genre.GenreFeedFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenreTvShowFragment : BaseFragment<FragmentGenreTvShowBinding>(
    FragmentGenreTvShowBinding::inflate
) {

    val args: GenreTvShowFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carouselSetup()
        initClick()

        binding.apply {
            tvGenreName.text = args.type?.replaceFirstChar {
                it.uppercase()
            }
        }

    }

    private fun initClick() {

        binding.profileButton.setOnClickListener{
            findNavController().navigate(R.id.action_genreTvShowFragment_to_profileFragment)
        }

        binding.chipMovies.setOnClickListener{
            findNavController().navigate(
                GenreTvShowFragmentDirections.actionGenreTvShowFragmentToGenreMovieFragment(args.type)
            )
        }
        binding.chipAll.setOnClickListener{
            findNavController().navigate(
                GenreTvShowFragmentDirections.actionGenreTvShowFragmentToGenreFeedFragment(args.type)
            )
        }
    }

    private fun carouselSetup() {
        binding.apply {

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