package com.w1nxclub.winxvideo.presentation.search

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.util.MockConstants.ACTION
import com.w1nxclub.winxvideo.core.util.MockConstants.ANIME
import com.w1nxclub.winxvideo.core.util.MockConstants.COMEDY
import com.w1nxclub.winxvideo.core.util.MockConstants.CRIME
import com.w1nxclub.winxvideo.core.util.MockConstants.DOCUMENTARY
import com.w1nxclub.winxvideo.core.util.MockConstants.DRAMA
import com.w1nxclub.winxvideo.core.util.MockConstants.FANTASY
import com.w1nxclub.winxvideo.core.util.MockConstants.HORROR
import com.w1nxclub.winxvideo.core.util.MockConstants.MYSTERY
import com.w1nxclub.winxvideo.core.util.MockConstants.ROMANTIC
import com.w1nxclub.winxvideo.core.util.MockConstants.SCIENCE_FICTION
import com.w1nxclub.winxvideo.core.util.MockConstants.THRILLER
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(
    FragmentSearchBinding::inflate
) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_searchFragment_to_profileFragment)
        }

        binding.action.setOnClickListener { view ->
            view.findNavController()
                .navigate(SearchFragmentDirections.actionSearchFragmentToGenreFeedFragment("action"))

        }

        binding.anime.setOnClickListener { view ->
            view.findNavController()
                .navigate(SearchFragmentDirections.actionSearchFragmentToGenreFeedFragment("anime"))

        }

        binding.comedy.setOnClickListener { view ->
            view.findNavController()
                .navigate(SearchFragmentDirections.actionSearchFragmentToGenreFeedFragment("comedy"))
        }

        binding.crime.setOnClickListener { view ->
            view.findNavController()
                .navigate(SearchFragmentDirections.actionSearchFragmentToGenreFeedFragment("crime"))
        }

        binding.documentary.setOnClickListener { view ->
            view.findNavController()
                .navigate(SearchFragmentDirections.actionSearchFragmentToGenreFeedFragment("documentary"))
        }

        binding.drama.setOnClickListener { view ->
            view.findNavController()
                .navigate(SearchFragmentDirections.actionSearchFragmentToGenreFeedFragment("drama"))
        }

        binding.fantasy.setOnClickListener { view ->
            view.findNavController()
                .navigate(SearchFragmentDirections.actionSearchFragmentToGenreFeedFragment("fantasy"))
        }

        binding.horror.setOnClickListener { view ->
            view.findNavController()
                .navigate(SearchFragmentDirections.actionSearchFragmentToGenreFeedFragment("horror"))
        }

        binding.mystery.setOnClickListener { view ->
            view.findNavController()
                .navigate(SearchFragmentDirections.actionSearchFragmentToGenreFeedFragment("mystery"))
        }

        binding.romantic.setOnClickListener { view ->
            view.findNavController()
                .navigate(SearchFragmentDirections.actionSearchFragmentToGenreFeedFragment("romantic"))
        }

        binding.scienceFiction.setOnClickListener { view ->
            view.findNavController()
                .navigate(SearchFragmentDirections.actionSearchFragmentToGenreFeedFragment("science fiction"))
        }

        binding.thriller.setOnClickListener { view ->
            view.findNavController()
                .navigate(SearchFragmentDirections.actionSearchFragmentToGenreFeedFragment("thriller"))
        }


    }

}