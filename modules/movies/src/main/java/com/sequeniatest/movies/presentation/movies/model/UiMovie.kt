package com.sequeniatest.movies.presentation.movies.model

import com.sequeniatest.movies.domain.model.Movie

sealed interface UiMovie {

    data class HeaderMovie(
        val header: String,
    ) : UiMovie

    data class MovieWrap(
        val items: List<Movie>,
    ) : UiMovie
}
