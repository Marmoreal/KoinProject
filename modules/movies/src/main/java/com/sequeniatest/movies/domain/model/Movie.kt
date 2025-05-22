package com.sequeniatest.movies.domain.model

data class Movie(
    val id: Int,
    val localizedName: String,
    val name: String,
    val year: Short,
    val rating: Double,
    val imageUrl: String,
    val description: String,
    val genres: List<String>,
)
