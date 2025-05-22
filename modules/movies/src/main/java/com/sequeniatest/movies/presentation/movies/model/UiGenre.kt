package com.sequeniatest.movies.presentation.movies.model

sealed class UiGenre(
    open val title: String,
    open var isSelected: Boolean = false,
) {

    data class HeaderGenre(
        override val title: String,
    ) : UiGenre(title)

    data class Genre(
        override val title: String,
        override var isSelected: Boolean,
    ) : UiGenre(title, isSelected)
}
