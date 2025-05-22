package com.sequeniatest.movies.presentation.movies.adapters

import androidx.recyclerview.widget.RecyclerView
import com.sequeniatest.movies.databinding.ItemGenreBinding
import com.sequeniatest.movies.presentation.movies.model.UiGenre

class GenreViewHolder(
    private val onGenreClick: (UiGenre) -> Unit,
    private val binding: ItemGenreBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(genre: UiGenre) = with(binding) {
        textViewGenre.text = genre.title
        root.setOnClickListener {
            onGenreClick(genre)
        }
    }
}
