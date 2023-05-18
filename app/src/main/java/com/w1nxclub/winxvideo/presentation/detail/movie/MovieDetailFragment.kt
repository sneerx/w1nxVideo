package com.w1nxclub.winxvideo.presentation.detail.movie

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.core.util.MockConstants.MOVIE_TYPE
import com.w1nxclub.winxvideo.core.util.downloadImage
import com.w1nxclub.winxvideo.core.util.showToast
import com.w1nxclub.winxvideo.data.model.Media
import com.w1nxclub.winxvideo.databinding.FragmentMovieDetailBinding
import com.w1nxclub.winxvideo.presentation.detail.MediaViewModel
import com.w1nxclub.winxvideo.presentation.detail.SharedDetailViewModel
import com.w1nxclub.winxvideo.presentation.detail.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding>(
    FragmentMovieDetailBinding::inflate
) {

    private val args: MovieDetailFragmentArgs by navArgs()
    private val sharedDetailViewModel: SharedDetailViewModel by activityViewModels()
    private val mediaViewModel: MediaViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClick()
        sendData(sharedDetailViewModel)

        lifecycleScope.launch {
            getMovieDetail()
        }

        setupViewPager()

    }

    private fun initClick() {
        binding.apply {
            profileButton.setOnClickListener {
                findNavController().navigate(R.id.action_movieDetailFragment_to_profileFragment)
            }
            linearFragment.setOnClickListener {
                requireContext().showToast("Not yet implemented")
            }
            linearShare.setOnClickListener {
                requireContext().showToast("Backendden sonra")
            }
        }
    }


    private fun sendData(viewModel: SharedDetailViewModel) {
        args.moviearg?.let { viewModel.saveMovieData(it) }
    }

    private suspend fun getMovieDetail() {
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

                val mediaMovie: Media = Media(
                    id = movie.id,
                    type = MOVIE_TYPE,
                    title = movie.title,
                    overview = movie.overview,
                    posterPath = movie.posterPath,
                    backdropPath = movie.backdropPath,
                    releaseDate = movie.releaseDate,
                    imdbRating = movie.imdbRating,
                    duration = movie.duration,
                    genres = movie.genres,
                    voteAverage = movie.voteAverage,
                    voteCount = movie.voteCount,
                    credits = movie.credits,
                    numberOfSeasons = null,
                    numberOfEpisodes = null
                )

                mediaViewModel.checkMediaExists(movie.id).observe(viewLifecycleOwner) {
                    if (it) {
                        ivWatchListIcon.downloadImage(R.drawable.baseline_check_24)
                        linearWatchList.setOnClickListener {
                            mediaViewModel.deleteMedia(mediaMovie.id)
                            Toast.makeText(requireContext(), "Silindi gomtanım", Toast.LENGTH_SHORT)
                                .show()
                        }
                    } else {
                        ivWatchListIcon.downloadImage(R.drawable.baseline_add_24)
                        linearWatchList.setOnClickListener {
                            mediaViewModel.insertMedia(mediaMovie)
                            Toast.makeText(requireContext(), "Eklendi gomtanım", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(requireParentFragment())
        binding.apply {
            viewPager2.isUserInputEnabled = false
            viewPager2.adapter = adapter

            TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
                when (position) {
                    0 -> tab.text = "İlgili"
                    1 -> tab.text = "Daha fazla ayrıntı"
                }
            }.attach()
        }
    }


}
