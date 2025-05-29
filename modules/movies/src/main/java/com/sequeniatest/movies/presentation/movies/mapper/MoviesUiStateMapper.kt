package com.sequeniatest.movies.presentation.movies.mapper

import android.content.Context
import com.sequeniatest.movies.R
import com.sequeniatest.movies.domain.model.Movie
import com.sequeniatest.movies.presentation.movies.model.MoviesUiState
import com.sequeniatest.movies.presentation.movies.model.UiGenre
import com.sequeniatest.movies.presentation.movies.model.UiMovie

class MoviesUiStateMapper(
    private val context: Context,
) {

    fun updateMovies(
        movies: List<Movie>,
    ): MoviesUiState {
        val titleGenres = UiGenre.HeaderGenre(context.getString(R.string.movies_genres_title))
        val sortedGenres = movies.flatMap { it.genres }.map {
            UiGenre.Genre(
                title = it,
                isSelected = false,
            )
        }.distinct()

        val titleMovies = UiMovie.HeaderMovie(context.getString(R.string.movies_title))
        val sortedMovies = movies.sortedBy { it.localizedName }

        return MoviesUiState.Success(
            genres = listOf(titleGenres) + sortedGenres,
            movies = listOf(titleMovies) + UiMovie.MovieWrap(sortedMovies),
        )
    }

    fun setError() = MoviesUiState.Error(context.getString(R.string.network_error_text))

    fun filterMoviesByGenre(
        currentState: MoviesUiState,
        selectedGenre: UiGenre,
    ): MoviesUiState {
        return if (currentState is MoviesUiState.Success) {

            val updatedGenres = currentState.genres.toMutableList().apply {
                map { it.isSelected = false }
                indexOfFirst { it == selectedGenre }.takeIf {
                    it >= 0
                }?.let {
                    val old = get(it) as UiGenre.Genre
                    set(it, old.copy(isSelected = !old.isSelected))
                }
            }

            val movies = (currentState.movies.last() as? UiMovie.MovieWrap)?.items.orEmpty()
            val filteredMovies = currentState.movies.toMutableList().apply {
                movies.filter { it.genres.contains(selectedGenre.title) }

            }

            currentState.copy(
                movies = filteredMovies,
                genres = updatedGenres
            )
        } else currentState
    }
}
