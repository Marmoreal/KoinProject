package com.sequeniatest.movies.domain.repository

import com.sequeniatest.movies.domain.model.Movie

interface MoviesRepository {

    suspend fun getMovies(): List<Movie>
}
