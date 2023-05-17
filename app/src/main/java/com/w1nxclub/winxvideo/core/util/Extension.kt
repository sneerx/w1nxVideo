package com.w1nxclub.winxvideo.core.util

import android.content.Context
import android.graphics.Color
import android.widget.ImageView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.jama.carouselview.CarouselView
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.data.model.movie.MovieResult
import com.w1nxclub.winxvideo.data.model.tvshow.TvShowResult
import com.w1nxclub.winxvideo.presentation.feed.movie.MovieFragmentDirections

fun CarouselView.carouselForMovie(
    movieResult: MovieResult,
    isAutoPlay: Boolean = false,
    layoutResource: Int,
    imgId: Int,
    destination: Int,
    isPoster: Boolean,
    enableSnapping: Boolean,
    hideIndicator: Boolean,
) {
    this.apply {
        size = movieResult.results.size
        autoPlay = isAutoPlay
        resource = layoutResource
        setCarouselViewListener { view, position ->
            val imageView = view.findViewById<ImageView>(imgId)

            if (isPoster) {
                movieResult.results[position].posterPath?.let { imageView.downloadImage(it) }
            } else {
                movieResult.results[position].backdropPath?.let { imageView.downloadImage(it) }
            }

            view.setOnClickListener {
                findNavController().navigate(
                    destination,
                    bundleOf("moviearg" to movieResult.results[position])
                )
            }
        }

        indicatorSelectedColor = Color.WHITE
        indicatorUnselectedColor = context.resources.getColor(R.color.indicator_unselected_color)
        indicatorRadius = 4

        enableSnapping(enableSnapping)
        hideIndicator(hideIndicator)
        show()
    }
}

fun CarouselView.carouselForTvShow(
    tvShowResult: TvShowResult,
    isAutoPlay: Boolean = false,
    layoutResource: Int,
    imgId: Int,
    destination: Int,
    isPoster: Boolean,
    enableSnapping: Boolean,
    hideIndicator: Boolean,
) {
    this.apply {
        size = tvShowResult.results.size
        autoPlay = isAutoPlay
        resource = layoutResource
        setCarouselViewListener { view, position ->
            val imageView = view.findViewById<ImageView>(imgId)

            if (isPoster) {
                tvShowResult.results[position].posterPath?.let { imageView.downloadImage(it) }
            } else {
                tvShowResult.results[position].backdropPath?.let { imageView.downloadImage(it) }
            }

            view.setOnClickListener {
                findNavController().navigate(
                    destination,
                    bundleOf("tvshowarg" to tvShowResult.results[position])
                )

            }
        }

        indicatorSelectedColor = Color.WHITE
        indicatorUnselectedColor = context.resources.getColor(R.color.indicator_unselected_color)
        indicatorRadius = 4

        enableSnapping(enableSnapping)
        hideIndicator(hideIndicator)
        show()
    }
}