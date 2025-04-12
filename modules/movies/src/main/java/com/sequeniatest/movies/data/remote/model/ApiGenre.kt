package com.sequeniatest.movies.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = false)
enum class ApiGenre {

    @Json(name = "биография")
    BIOGRAPHY,

    @Json(name = "боевик")
    ACTION,

    @Json(name = "детектив")
    DETECTIVE,

    @Json(name = "драма")
    DRAMA,

    @Json(name = "комедия")
    COMEDY,

    @Json(name = "криминал")
    CRIME,

    @Json(name = "мелодрама")
    MELODRAMA,

    @Json(name = "мюзикл")
    MUSICAL,

    @Json(name = "приключения")
    ADVENTURE,

    @Json(name = "триллер")
    THRILLER,

    @Json(name = "ужасы")
    HORROR,

    @Json(name = "фантастика")
    SCI_FI,

    @Json(name = "фэнтези")
    FANTASY,
}
