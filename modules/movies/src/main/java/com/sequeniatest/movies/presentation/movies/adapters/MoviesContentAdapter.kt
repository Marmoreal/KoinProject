package com.sequeniatest.movies.presentation.movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sequeniatest.movies.databinding.ItemHeaderBinding
import com.sequeniatest.movies.databinding.ItemMovieListBinding
import com.sequeniatest.movies.domain.model.Movie
import com.sequeniatest.movies.presentation.movies.model.UiMovie

private const val HEADER_TYPE = 0
private const val MOVIES_TYPE = 1

class MoviesContentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<UiMovie>()
    var onMovieClick: (Movie) -> Unit = {}

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            HEADER_TYPE -> HeaderViewHolder(
                binding = ItemHeaderBinding.inflate(layoutInflater, parent, false)
            )
            MOVIES_TYPE -> MoviesListViewHolder(
                onMovieClick = onMovieClick,
                binding = ItemMovieListBinding.inflate(layoutInflater, parent, false)
            )
            else -> error("Unsupported view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> holder.bind(
                title = (getItem(position) as UiMovie.HeaderMovie).header,
            )
            is MoviesListViewHolder -> holder.bind(getItem(position) as UiMovie.MovieWrap)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) HEADER_TYPE else MOVIES_TYPE
    }

    private fun getItem(position: Int): UiMovie {
        return items[position]
    }

    fun submitList(items: List<UiMovie>) {
        this.items.apply {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }
}
