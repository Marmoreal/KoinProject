package com.sequeniatest.movies.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiMovie(
    val id: Int?,
    @Json(name = "localized_name") val localizedName: String?,
    val name: String?,
    val year: Short?,
    val rating: Double?,
    @Json(name = "image_url") val imageUrl: String?,
    val description: String?,
    val genres: List<ApiGenre?>?,
)
