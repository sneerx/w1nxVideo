package com.w1nxclub.winxvideo.presentation.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.core.util.MockConstants.COMEDY
import com.w1nxclub.winxvideo.core.util.MockConstants.CRIME
import com.w1nxclub.winxvideo.core.util.MockData.movies
import com.w1nxclub.winxvideo.core.util.MockData.tvshow
import com.w1nxclub.winxvideo.core.util.carouselForMovie
import com.w1nxclub.winxvideo.core.util.carouselForTvShow
import com.w1nxclub.winxvideo.data.model.movie.MockMovie.mockMovieResult
import com.w1nxclub.winxvideo.data.model.movie.Movie
import com.w1nxclub.winxvideo.data.model.movie.MovieResult
import com.w1nxclub.winxvideo.data.model.tvshow.MockTvShow.mockTvShowResult
import com.w1nxclub.winxvideo.data.model.tvshow.TvShow
import com.w1nxclub.winxvideo.data.model.tvshow.TvShowResult
import com.w1nxclub.winxvideo.databinding.FragmentFeedBinding
import com.w1nxclub.winxvideo.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : BaseFragment<FragmentFeedBinding>(
    FragmentFeedBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClick()
        carouselSetup()
    }

    private fun carouselSetup() {
        binding.apply {
            mainCarouselView.carouselForMovie(
                movieResult = mockMovieResult,
                isAutoPlay = true,
                layoutResource = R.layout.carousel_backdrop_image_item,
                imgId = R.id.ivBackdropCarousel,
                destination = R.id.action_feedFragment_to_movieDetailFragment,
                isPoster = false,
                enableSnapping = true,
                hideIndicator = false
            )

            carouselSuggestionMovie.carouselForMovie(
                movieResult = mockMovieResult,
                isAutoPlay = false,
                layoutResource = R.layout.carousel_poster_item,
                imgId = R.id.ivPosterCarousel,
                destination = R.id.action_feedFragment_to_movieDetailFragment,
                isPoster = true,
                enableSnapping = false,
                hideIndicator = true
            )

            carouselAmazonOriginalContent.carouselForMovie(
                movieResult = mockMovieResult,
                isAutoPlay = false,
                layoutResource = R.layout.carousel_poster_item,
                imgId = R.id.ivPosterCarousel,
                destination = R.id.action_feedFragment_to_movieDetailFragment,
                isPoster = true,
                enableSnapping = false,
                hideIndicator = true
            )

            carouselMostWatchedTv.carouselForTvShow(
                tvShowResult = mockTvShowResult,
                isAutoPlay = false,
                layoutResource = R.layout.carousel_poster_item,
                imgId = R.id.ivPosterCarousel,
                destination = R.id.action_feedFragment_to_tvShowDetailFragment,
                isPoster = true,
                enableSnapping = false,
                hideIndicator = true
            )

            val crimeTvShow: TvShow? = tvshow.find { tvShow ->

                tvShow.genres!!.any { genre ->
                    genre.id == CRIME
                }
            }
            val result = TvShowResult(arrayListOf(crimeTvShow!!))
            carouselDramaTv.carouselForTvShow(
                result,
                isAutoPlay = false,
                layoutResource = R.layout.carousel_poster_item,
                imgId = R.id.ivPosterCarousel,
                destination = R.id.action_feedFragment_to_tvShowDetailFragment,
                isPoster = true,
                enableSnapping = false,
                hideIndicator = true
            )

            carouselMostWatchedMovie.carouselForMovie(
                movieResult = mockMovieResult,
                isAutoPlay = false,
                layoutResource = R.layout.carousel_poster_item,
                imgId = R.id.ivPosterCarousel,
                destination = R.id.action_feedFragment_to_movieDetailFragment,
                isPoster = true,
                enableSnapping = false,
                hideIndicator = true
            )

            val comedyMovie: Movie? = movies.find { movie ->

                movie.genres!!.any { genre ->
                    genre.id == COMEDY
                }
            }
            val comedyResult = MovieResult(arrayListOf(comedyMovie!!))
            carouselComedyMovie.carouselForMovie(
                movieResult = comedyResult,
                isAutoPlay = false,
                layoutResource = R.layout.carousel_poster_item,
                imgId = R.id.ivPosterCarousel,
                destination = R.id.action_feedFragment_to_movieDetailFragment,
                isPoster = true,
                enableSnapping = false,
                hideIndicator = true
            )
        }
    }

    private fun initClick() {
        binding.apply {
            chipTvSeries.setOnClickListener {
                findNavController().navigate(R.id.action_feedFragment_to_tvShowFragment)
            }

            chipMovies.setOnClickListener {
                findNavController().navigate(R.id.action_feedFragment_to_movieFragment)
            }

            profileButton.setOnClickListener {
                findNavController().navigate(R.id.action_feedFragment_to_profileFragment)
            }
        }
    }
}

