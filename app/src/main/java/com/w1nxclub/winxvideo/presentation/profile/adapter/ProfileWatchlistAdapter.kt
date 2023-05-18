package com.w1nxclub.winxvideo.presentation.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.w1nxclub.winxvideo.core.util.MockConstants.MOVIE_TYPE
import com.w1nxclub.winxvideo.core.util.downloadImage
import com.w1nxclub.winxvideo.data.model.Media
import com.w1nxclub.winxvideo.databinding.ItemWatchlistBinding

class ProfileWatchlistAdapter(
    private val onMoreVertClickListener: OnMoreVertClickListener
) :
    RecyclerView.Adapter<ProfileWatchlistAdapter.ProfileViewHolder>() {

    var emptyList = emptyList<Media>()

    fun setData(watchList: List<Media>) {
        emptyList = watchList
        notifyDataSetChanged()
    }

    inner class ProfileViewHolder(val binding: ItemWatchlistBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        return ProfileViewHolder(
            ItemWatchlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val item = emptyList[position]

        holder.binding.apply {
            item.backdropPath?.let { ivWatchlistBackdrop.downloadImage(it) }
            tvWatchListName.text = item.title
            tvReleaseYear.text = item.releaseDate
            if (item.type == MOVIE_TYPE) {
                tvDuration.text = "${item.duration} dk"
            } else {
                tvDuration.text = "${item.numberOfSeasons} Sezon"
            }

            ivMoreVert.setOnClickListener {
                onMoreVertClickListener.onItemClicked(item)
            }

            holder.itemView.setOnClickListener {
                onItemClickListener?.let { it(item) }
            }
        }
    }

    override fun getItemCount(): Int = emptyList.size

    private var onItemClickListener: ((Media) -> Unit)? = null

    fun setOnItemClickListener(listener: (Media) -> Unit) {
        onItemClickListener = listener
    }
}

interface OnMoreVertClickListener {
    fun onItemClicked(media: Media)
}