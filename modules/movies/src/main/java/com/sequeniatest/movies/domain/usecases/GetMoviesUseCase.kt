package com.sequeniatest.movies.domain.usecases

import com.sequeniatest.movies.domain.LoadableResult
import com.sequeniatest.movies.domain.model.Movie
import com.sequeniatest.movies.domain.repository.MoviesRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMoviesUseCase(
    private val repository: MoviesRepository,
) {

    fun execute(): Flow<LoadableResult<List<Movie>>> {
        return loadData { repository.getMovies() }
    }

    private fun loadData(
        block: suspend () -> List<Movie>,
    ): Flow<LoadableResult<List<Movie>>> = flow {
        try {
            emit(LoadableResult.Loading())
            val result = block()
            emit(LoadableResult.Success(result))
        } catch (error: Throwable) {
            emit(LoadableResult.Failure())
        }
    }
}
