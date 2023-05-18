package com.w1nxclub.winxvideo.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.core.util.setGone
import com.w1nxclub.winxvideo.core.util.setVisible
import com.w1nxclub.winxvideo.data.model.Media
import com.w1nxclub.winxvideo.data.model.movie.Movie
import com.w1nxclub.winxvideo.data.model.tvshow.TvShow
import com.w1nxclub.winxvideo.databinding.FragmentProfileBinding
import com.w1nxclub.winxvideo.presentation.detail.MediaViewModel
import com.w1nxclub.winxvideo.presentation.profile.adapter.OnMoreVertClickListener
import com.w1nxclub.winxvideo.presentation.profile.adapter.ProfileWatchlistAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(
    FragmentProfileBinding::inflate
), OnMoreVertClickListener {

    private lateinit var watchListAdapter: ProfileWatchlistAdapter
    private val mediaViewModel: MediaViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        getSavedMedia()
        initClick()


    }

    private fun initClick() {
        watchListAdapter.setOnItemClickListener { media ->
            if (media.type == "movie") {
                val movieType = Movie(
                    id = media.id,
                    title = media.title,
                    overview = media.overview,
                    posterPath = media.posterPath,
                    backdropPath = media.backdropPath,
                    releaseDate = media.releaseDate,
                    imdbRating = media.imdbRating,
                    duration = media.duration,
                    genres = media.genres,
                    voteAverage = media.voteAverage,
                    voteCount = media.voteCount,
                    credits = media.credits
                )
                findNavController().navigate(
                    ProfileFragmentDirections.actionProfileFragmentToMovieDetailFragment(movieType)
                )

            } else {
                val tvshowtype = TvShow(
                    id = media.id,
                    title = media.title,
                    overview = media.overview,
                    posterPath = media.posterPath,
                    backdropPath = media.backdropPath,
                    releaseDate = media.releaseDate,
                    imdbRating = media.imdbRating,
                    genres = media.genres,
                    voteAverage = media.voteAverage,
                    voteCount = media.voteCount,
                    credits = media.credits,
                    numberOfSeasons = media.numberOfSeasons,
                    numberOfEpisodes = media.numberOfEpisodes
                )
                findNavController().navigate(
                    ProfileFragmentDirections.actionProfileFragmentToTvShowDetailFragment(tvshowtype)
                )
            }
        }
    }

    private fun getSavedMedia() {
        binding.apply {
            mediaViewModel.getSavedMedia().observe(viewLifecycleOwner) {
                if (it.isEmpty()) {
                    rvWatchlist.setGone()
                    tvBombos.setVisible()
                    tvDutluk.setVisible()
                } else {
                    tvBombos.setGone()
                    tvDutluk.setGone()
                    watchListAdapter.setData(it)
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.apply {
            watchListAdapter = ProfileWatchlistAdapter(this@ProfileFragment)
            rvWatchlist.apply {
                adapter = watchListAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            }
        }
    }

    override fun onItemClicked(media: Media) {
        findNavController().navigate(
            ProfileFragmentDirections.actionProfileFragmentToProfileBottomSheetFragment(media)
        )
    }
}