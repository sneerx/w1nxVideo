package com.w1nxclub.winxvideo.presentation.detail.tvshow

import android.os.Bundle
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
import com.w1nxclub.winxvideo.core.util.MockConstants.TVSHOW_TYPE
import com.w1nxclub.winxvideo.core.util.downloadImage
import com.w1nxclub.winxvideo.data.model.Media
import com.w1nxclub.winxvideo.databinding.FragmentTvShowDetailBinding
import com.w1nxclub.winxvideo.presentation.detail.MediaViewModel
import com.w1nxclub.winxvideo.presentation.detail.SharedDetailViewModel
import com.w1nxclub.winxvideo.presentation.detail.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TvShowDetailFragment : BaseFragment<FragmentTvShowDetailBinding>(
    FragmentTvShowDetailBinding::inflate
) {

    private val args: TvShowDetailFragmentArgs by navArgs()
    private val sharedDetailViewModel: SharedDetailViewModel by activityViewModels()
    private val mediaViewModel: MediaViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClick()

        lifecycleScope.launch {
            getTvShowDetail()
        }
        setupViewPager()
        sendData(sharedDetailViewModel)
    }

    private fun initClick() {
        binding.apply {
            profileButton.setOnClickListener {
                findNavController().navigate(R.id.action_tvShowDetailFragment_to_profileFragment)
            }
        }
    }

    private fun sendData(viewModel: SharedDetailViewModel) {
        args.tvshowarg?.let { viewModel.saveTvShowData(it) }
    }

    private suspend fun getTvShowDetail() {
        binding.apply {
            args.tvshowarg?.let { tvShow ->
                tvShow.backdropPath?.let { ivTvShowBackdrop.downloadImage(it) }
                tvTvShowName.text = tvShow.title
                tvSeasonCount.text = "${tvShow.numberOfSeasons} Sezon"
                tvOverview.text = tvShow.overview
                val genre = tvShow.genres?.joinToString(", ") { it.name.toString() }
                tvGenres.text = genre
                tvImdbRating.text = "IMDb ${tvShow.imdbRating}"
                tvReleaseYear.text = tvShow.releaseDate
                tvEpisodeCount.text = "${tvShow.numberOfEpisodes} Bölüm"

                val mediaTvShow: Media = Media(
                    id = tvShow.id,
                    type = TVSHOW_TYPE,
                    title = tvShow.title,
                    overview = tvShow.overview,
                    posterPath = tvShow.posterPath,
                    backdropPath = tvShow.backdropPath,
                    releaseDate = tvShow.releaseDate,
                    imdbRating = tvShow.imdbRating,
                    duration = null,
                    genres = tvShow.genres,
                    voteAverage = tvShow.voteAverage,
                    voteCount = tvShow.voteCount,
                    credits = tvShow.credits,
                    numberOfSeasons = tvShow.numberOfSeasons,
                    numberOfEpisodes = tvShow.numberOfEpisodes
                )

                mediaViewModel.checkMediaExists(mediaTvShow.id).observe(viewLifecycleOwner) {
                    if (it) {
                        ivWatchListIcon.downloadImage(R.drawable.baseline_check_24)
                        linearWatchList.setOnClickListener {
                            mediaViewModel.deleteMedia(mediaTvShow.id)
                            Toast.makeText(requireContext(), "Silindi gomtanım", Toast.LENGTH_SHORT)
                                .show()
                        }
                    } else {
                        ivWatchListIcon.downloadImage(R.drawable.baseline_add_24)
                        linearWatchList.setOnClickListener {
                            mediaViewModel.insertMedia(mediaTvShow)
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