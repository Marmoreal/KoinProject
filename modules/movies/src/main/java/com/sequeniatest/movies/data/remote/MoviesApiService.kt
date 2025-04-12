package com.sequeniatest.movies.data.remote

import com.sequeniatest.movies.data.remote.model.ApiMoviesResponse
import retrofit2.http.GET

interface MoviesApiService {

    /** Получить список вопросов к товару */
    @GET("films")
    suspend fun getMovies(): ApiMoviesResponse
}
