package com.sequeniatest.movies.presentation.movies.adapters

import androidx.recyclerview.widget.RecyclerView
import com.sequeniatest.movies.databinding.ItemMovieListBinding
import com.sequeniatest.movies.domain.model.Movie
import com.sequeniatest.movies.presentation.movies.model.UiMovie

class MoviesListViewHolder(
    onMovieClick: (Movie) -> Unit,
    private val binding: ItemMovieListBinding,
) : RecyclerView.ViewHolder(binding.root) {

    private val movieAdapter = MovieAdapter()

    init {
        movieAdapter.onMovieClick = onMovieClick
    }

    fun bind(item: UiMovie.MovieWrap) = with(binding) {
        movieAdapter.submitList(item.items)

        recyclerViewMovies.adapter = movieAdapter
    }
}
