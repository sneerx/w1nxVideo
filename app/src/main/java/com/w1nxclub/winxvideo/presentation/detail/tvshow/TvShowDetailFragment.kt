package com.w1nxclub.winxvideo.presentation.detail.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.core.util.downloadImage
import com.w1nxclub.winxvideo.databinding.FragmentTvShowDetailBinding
import com.w1nxclub.winxvideo.presentation.detail.SharedDetailViewModel
import com.w1nxclub.winxvideo.presentation.detail.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowDetailFragment : BaseFragment<FragmentTvShowDetailBinding>(
    FragmentTvShowDetailBinding::inflate
) {

    private val args: TvShowDetailFragmentArgs by navArgs()
    private val sharedDetailViewModel: SharedDetailViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getTvShowDetail()
        setupViewPager()
        sendData(sharedDetailViewModel)
    }

    private fun sendData(viewModel: SharedDetailViewModel) {
        args.tvshowarg?.let { viewModel.saveTvShowData(it) }
    }
    private fun getTvShowDetail() {
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
            }
        }
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(requireParentFragment())
        binding.apply {
            viewPager2.isUserInputEnabled = false
            viewPager2.adapter = adapter

            TabLayoutMediator(tabLayout, viewPager2){ tab, position ->
                when (position) {
                    0 -> tab.text = "İlgili"
                    1 -> tab.text = "Daha fazla ayrıntı"
                }
            }.attach()
        }
    }
}