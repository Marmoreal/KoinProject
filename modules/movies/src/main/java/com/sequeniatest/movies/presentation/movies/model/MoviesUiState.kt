package com.sequeniatest.movies.presentation.movies.model

sealed class MoviesUiState {

    data object Loading : MoviesUiState()
    data class Success(
        val genres: List<UiGenre> = emptyList(),
        val movies: List<UiMovie> = emptyList(),
    ) : MoviesUiState()

    data class Error(
        val message: String,
    ) : MoviesUiState()
}
