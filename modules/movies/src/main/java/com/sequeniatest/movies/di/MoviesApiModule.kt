package com.sequeniatest.movies.di

import com.sequeniatest.movies.data.remote.MoviesApiService
import com.sequeniatest.movies.data.remote.SemimockMoviesApiService
import retrofit2.Retrofit
import retrofit2.create

fun provideMoviesApiService(
    retrofit: Retrofit
): MoviesApiService {
    return SemimockMoviesApiService(
        apiService = retrofit.create(),
    )
}
