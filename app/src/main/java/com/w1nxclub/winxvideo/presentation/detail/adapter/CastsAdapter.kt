package com.w1nxclub.winxvideo.presentation.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.w1nxclub.winxvideo.R
import com.w1nxclub.winxvideo.core.util.downloadImage
import com.w1nxclub.winxvideo.data.model.credits.Cast
import com.w1nxclub.winxvideo.databinding.ItemCastsBinding

class CastsAdapter(val castList: List<Cast>) : RecyclerView.Adapter<CastsAdapter.CastViewHolder>() {

    inner class CastViewHolder(val binding: ItemCastsBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        return CastViewHolder(
            ItemCastsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        val cast = castList[position]

        holder.binding.apply {
            cast.profilePath?.let { ivCastProfilePath.downloadImage(it) }
                ?: ivCastProfilePath.downloadImage(
                    R.drawable.no_image
                )
            tvCastName.text = cast.name ?: ""
        }
    }

    override fun getItemCount(): Int = castList.size
}