package com.sequeniatest.movies.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sequeniatest.movies.domain.LoadableResult
import com.sequeniatest.movies.domain.model.Movie
import com.sequeniatest.movies.domain.usecases.GetMoviesUseCase
import com.sequeniatest.movies.presentation.movies.mapper.MoviesUiStateMapper
import com.sequeniatest.movies.presentation.movies.model.MoviesUiState
import com.sequeniatest.movies.presentation.movies.model.UiGenre
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MoviesViewModel(
    private val mapper: MoviesUiStateMapper,
    getMoviesUseCase: GetMoviesUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<MoviesUiState>(MoviesUiState.Loading)
    val state = _state.asStateFlow()

    init {
        getMoviesUseCase.execute().onEach { result ->
            _state.value = when (result) {
                is LoadableResult.Loading -> {
                    MoviesUiState.Loading
                }
                is LoadableResult.Success -> {
                    mapper.updateMovies(
                        movies = result.value,
                    )
                }
                is LoadableResult.Failure -> {
                    mapper.setError()
                }
            }
        }.launchIn(viewModelScope)
    }

    fun filterMoviesByGenre(genre: UiGenre) {
        _state.value = mapper.filterMoviesByGenre(
            currentState = _state.value,
            selectedGenre = genre,
        )
    }

    fun openMovie(movie: Movie) {

    }
}
