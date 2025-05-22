package com.sequeniatest.movies.presentation.movies.adapters

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sequeniatest.movies.R
import com.sequeniatest.movies.databinding.ItemMovieBinding
import com.sequeniatest.movies.domain.model.Movie

class MovieViewHolder(
    private val onMovieClick: (Movie) -> Unit,
    private val binding: ItemMovieBinding,
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Movie) = with(binding) {
        root.setOnClickListener {
            onMovieClick(item)
        }

        val placeholderRes = R.drawable.img_movie_placeholder
        imageViewPoster.load(item.imageUrl) {
            placeholder(placeholderRes)
            error(placeholderRes)
        }

        textViewName.text = item.localizedName
    }
}
