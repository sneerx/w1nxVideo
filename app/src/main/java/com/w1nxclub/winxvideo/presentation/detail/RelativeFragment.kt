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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.base.BaseFragment
import com.w1nxclub.winxvideo.core.util.downloadImage
import com.w1nxclub.winxvideo.data.model.credits.Cast
import com.w1nxclub.winxvideo.data.model.movie.Movie
import com.w1nxclub.winxvideo.databinding.FragmentRelativeBinding
import com.w1nxclub.winxvideo.presentation.detail.adapter.CastsAdapter
import kotlinx.coroutines.launch

class RelativeFragment : BaseFragment<FragmentRelativeBinding>(
    FragmentRelativeBinding::inflate
) {

    private lateinit var castsAdapter: CastsAdapter
    private val sharedDetailViewModel: SharedDetailViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData(sharedDetailViewModel)
    }

    private fun getData(viewModel: SharedDetailViewModel) {
        binding.apply {

            viewModel.isMovie.observe(viewLifecycleOwner) {isMovie->
                if (isMovie) {
                    viewModel.movieData.observe(viewLifecycleOwner) { movie ->
                        val castsList = movie?.credits?.cast
                        castsList?.let { initRecyclerView(it) }
                        movie.credits?.director?.profilePath?.let {
                            ivCastProfilePath.downloadImage(
                                it
                            )
                        }
                            ?: ivCastProfilePath.downloadImage(R.drawable.no_image)
                        tvCastName.text = movie.credits?.director?.name ?: ""
                    }
                } else {
                    viewModel.tvShowData.observe(viewLifecycleOwner) { tvShow ->
                        val castsList = tvShow?.credits?.cast
                        castsList?.let { initRecyclerView(it) }
                        tvShow.credits?.director?.profilePath?.let { ivCastProfilePath.downloadImage(it) }
                            ?: ivCastProfilePath.downloadImage(R.drawable.no_image)
                        tvCastName.text = tvShow.credits?.director?.name ?: ""
                    }
                }
            }



        }
    }

    private fun initRecyclerView(castList: List<Cast>) {
        castsAdapter = CastsAdapter(castList)
        binding.rvCasts.apply {
            adapter = castsAdapter
            layoutManager =
                GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false)

        }
    }
}