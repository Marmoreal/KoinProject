package com.sequeniatest.movies.presentation.movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sequeniatest.movies.databinding.ItemGenreBinding
import com.sequeniatest.movies.databinding.ItemHeaderBinding
import com.sequeniatest.movies.presentation.movies.model.UiGenre

private const val HEADER_TYPE = 0
private const val ITEM_TYPE = 1

class GenresAdapter : ListAdapter<UiGenre, RecyclerView.ViewHolder>(GenreItemCallback) {

    var onGenreClick: (UiGenre) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            HEADER_TYPE -> {
                HeaderViewHolder(
                    binding = ItemHeaderBinding.inflate(layoutInflater, parent, false)
                )
            }
            ITEM_TYPE -> {
                GenreViewHolder(
                    onGenreClick = onGenreClick,
                    binding = ItemGenreBinding.inflate(layoutInflater, parent, false)
                )
            }
            else -> error("Unsupported view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> {
                holder.bind(getItem(position).title)
            }
            is GenreViewHolder -> {
                holder.bind(getItem(position))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) HEADER_TYPE else ITEM_TYPE
    }

    private object GenreItemCallback : DiffUtil.ItemCallback<UiGenre>() {
        override fun areItemsTheSame(oldItem: UiGenre, newItem: UiGenre): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UiGenre, newItem: UiGenre): Boolean {
            return oldItem == newItem
        }
    }
}
