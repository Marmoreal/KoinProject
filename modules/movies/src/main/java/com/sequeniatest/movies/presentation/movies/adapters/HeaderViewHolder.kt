package com.sequeniatest.movies.presentation.movies.adapters

import androidx.recyclerview.widget.RecyclerView
import com.sequeniatest.movies.databinding.ItemHeaderBinding

class HeaderViewHolder(
    private val binding: ItemHeaderBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(title: String) {
        binding.textViewHeader.text = title
    }
}
