package com.sequeniatest.movies.data.remote

class SemimockMoviesApiService(
    apiService: MoviesApiService,
) : MoviesApiService by apiService
