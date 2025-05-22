package com.sequeniatest.movies.presentation.movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sequeniatest.movies.databinding.ItemMovieBinding
import com.sequeniatest.movies.domain.model.Movie

class MovieAdapter : ListAdapter<Movie, MovieViewHolder>(MovieItemCallback) {

    var onMovieClick: (Movie) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            binding = ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            onMovieClick = onMovieClick,
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private object MovieItemCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}