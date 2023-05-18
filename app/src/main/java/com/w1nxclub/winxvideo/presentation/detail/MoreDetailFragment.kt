package com.w1nxclub.winxvideo.presentation.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.data.model.movie.Movie
import com.w1nxclub.winxvideo.databinding.FragmentMoreDetailBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MoreDetailFragment : BaseFragment<FragmentMoreDetailBinding>(
    FragmentMoreDetailBinding::inflate
) {

    private val sharedDetailViewModel: SharedDetailViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()


    }

    private fun getData() {

        sharedDetailViewModel.isMovie.observe(viewLifecycleOwner){ isMovie ->
            if (isMovie) {
                sharedDetailViewModel.movieData.observe(viewLifecycleOwner) { movie ->
                    binding.apply {
                        val genre = movie.genres?.joinToString(", ") { it.name.toString() }
                        tvGenres.text = genre ?: getString(R.string.tur_bilgisi_yok)

                        tvDirector.text = movie.credits?.director?.name
                            ?: getString(R.string.yonetmen_bilgisi_yok)

                        val casts = movie.credits?.cast?.joinToString(", ") { it.name }
                        tvCast.text = casts ?: getString(R.string.basrol_bilgisi_yok)
                    }
                }
            } else {
                sharedDetailViewModel.tvShowData.observe(viewLifecycleOwner) { tvShow ->
                    binding.apply {
                        val genre = tvShow.genres?.joinToString(", ") { it.name.toString() }
                        tvGenres.text = genre ?: getString(R.string.tur_bilgisi_yok)

                        tvDirector.text = tvShow.credits?.director?.name ?: getString(R.string.yonetmen_bilgisi_yok)

                        val casts = tvShow.credits?.cast?.joinToString(", ") { it.name }
                        tvCast.text = casts ?: getString(R.string.basrol_bilgisi_yok)
                    }
                }
            }
        }


    }

}