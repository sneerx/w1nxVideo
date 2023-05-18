package com.w1nxclub.winxvideo.presentation.downloads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.databinding.FragmentDownloadsBinding
// -- 
import dagger.hilt.android.AndroidEntryPoint

//entrypoint
@AndroidEntryPoint
class DownloadsFragment : BaseFragment<FragmentDownloadsBinding>(
    FragmentDownloadsBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_downloadsFragment_to_profileFragment)
        }
        }
    }
