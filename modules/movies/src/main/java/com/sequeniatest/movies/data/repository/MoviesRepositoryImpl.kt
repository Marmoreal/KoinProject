package com.sequeniatest.movies.data.repository

import com.sequeniatest.movies.data.mapper.MoviesMapper
import com.sequeniatest.movies.data.remote.MoviesApiService
import com.sequeniatest.movies.domain.model.Movie
import com.sequeniatest.movies.domain.repository.MoviesRepository

class MoviesRepositoryImpl(
    private val moviesApiService: MoviesApiService,
    private val mapper: MoviesMapper,
) : MoviesRepository {

    override suspend fun getMovies(): List<Movie> {
        return moviesApiService.getMovies().films.orEmpty().mapNotNull { mapper.fromApiToModel(it) }
    }
}