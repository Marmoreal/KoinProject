package com.sequeniatest.movies.data.mapper

import com.sequeniatest.movies.data.helper.orDefault
import com.sequeniatest.movies.data.remote.model.ApiGenre
import com.sequeniatest.movies.data.remote.model.ApiMovie
import com.sequeniatest.movies.domain.model.Genre
import com.sequeniatest.movies.domain.model.Movie

class MoviesMapper {

    private val genresMapper = mapOf(
        ApiGenre.BIOGRAPHY to Genre.BIOGRAPHY,
        ApiGenre.ACTION to Genre.ACTION,
        ApiGenre.DETECTIVE to Genre.DETECTIVE,
        ApiGenre.DRAMA to Genre.DRAMA,
        ApiGenre.COMEDY to Genre.COMEDY,
        ApiGenre.CRIME to Genre.CRIME,
        ApiGenre.MELODRAMA to Genre.MELODRAMA,
        ApiGenre.MUSICAL to Genre.MUSICAL,
        ApiGenre.ADVENTURE to Genre.ADVENTURE,
        ApiGenre.THRILLER to Genre.THRILLER,
        ApiGenre.HORROR to Genre.HORROR,
        ApiGenre.SCI_FI to Genre.SCI_FI,
        ApiGenre.FANTASY to Genre.FANTASY,
    )

    fun fromApiToModel(api: ApiMovie?): Movie {
        return Movie(
            id = api?.id.orDefault(),
            localizedName = api?.localizedName.orEmpty(),
            name = api?.name.orEmpty(),
            year = api?.year.orDefault(),
            rating = api?.rating.orDefault(),
            imageUrl = api?.imageUrl.orEmpty(),
            description = api?.description.orEmpty(),
            genres = api?.genres.orEmpty().mapNotNull { genresMapper.getOrDefault(it, Genre.UNCONFINED) }
        )
    }
}
