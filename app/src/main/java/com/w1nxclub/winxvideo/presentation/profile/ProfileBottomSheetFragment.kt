package com.w1nxclub.winxvideo.presentation.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.databinding.FragmentProfileBottomSheetBinding
import com.w1nxclub.winxvideo.presentation.detail.MediaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileBottomSheetFragment : BottomSheetDialogFragment() {

    private val args: ProfileBottomSheetFragmentArgs by navArgs()
    private lateinit var binding: FragmentProfileBottomSheetBinding
    private val viewModel: MediaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        deleteFromWatchlist()
    }

    private fun getData() {
        binding.apply {
            args.media?.let {
                tvMediaName.text = args.media?.title
                if (args.media?.type == "movie") {
                    tvDurationOrSeason.text = "${args.media?.duration} Dk"
                } else {
                    tvDurationOrSeason.text = "${args.media?.numberOfSeasons} Sezon"
                }
            }

        }
    }

    private fun deleteFromWatchlist() {
        binding.apply {
            linearWatchlist.setOnClickListener {
                args.media?.let { it1 -> viewModel.deleteMedia(it1.id) }
                dismiss()
            }
        }
    }
}