package com.sequeniatest.movies.data.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiMoviesResponse(
    val films: List<ApiMovie?>?,
)
