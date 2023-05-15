package com.w1nxclub.winxvideo.presentation.detail.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.databinding.FragmentTvShowDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowDetailFragment : BaseFragment<FragmentTvShowDetailBinding>(
    FragmentTvShowDetailBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}