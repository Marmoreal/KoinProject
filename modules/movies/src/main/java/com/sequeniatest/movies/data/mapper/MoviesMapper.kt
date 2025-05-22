package com.sequeniatest.movies.data.mapper

import com.sequeniatest.movies.data.extension.orDefault
import com.sequeniatest.movies.data.remote.model.ApiMovie
import com.sequeniatest.movies.domain.model.Movie

class MoviesMapper {

    fun fromApiToModel(api: ApiMovie?): Movie {
        return Movie(
            id = api?.id.orDefault(),
            localizedName = api?.localizedName.orEmpty(),
            name = api?.name.orEmpty(),
            year = api?.year.orDefault(),
            rating = api?.rating.orDefault(),
            imageUrl = api?.imageUrl.orEmpty(),
            description = api?.description.orEmpty(),
            genres = api?.genres.orEmpty().mapNotNull { it.orEmpty() },
        )
    }
}
