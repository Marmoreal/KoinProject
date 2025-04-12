package com.sequeniatest.movies.data.remote

import com.sequeniatest.movies.data.remote.model.ApiGenre
import com.sequeniatest.movies.data.remote.model.ApiMovie
import com.sequeniatest.movies.data.remote.model.ApiMoviesResponse

class MockMoviesApiService() : MoviesApiService {
    override suspend fun getMovies() = ApiMoviesResponse(
        films = listOf(
            ApiMovie(
                id = 326,
                localizedName = "Побег из Шоушенка",
                name = "The Shawshank Redemption",
                year = 1994,
                rating = 9.196,
                imageUrl = "https://st.kp.yandex.net/images/film_iphone/iphone360_326.jpg",
                description = "Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.",
                genres = listOf(
                    ApiGenre.DRAMA,
                ),
            ),
            ApiMovie(
                id = 435,
                localizedName = "Зеленая миля",
                name = "The Green Mile",
                year = 1999,
                rating = 9.064,
                imageUrl = "https://st.kp.yandex.net/images/film_iphone/iphone360_435.jpg",
                description = "Обвиненный в страшном преступлении, Джон Коффи оказывается в блоке смертников тюрьмы «Холодная гора». Вновь прибывший обладал поразительным ростом и был пугающе спокоен, что, впрочем, никак не влияло на отношение к нему начальника блока Пола Эджкомба, привыкшего исполнять приговор. Гигант удивил всех позже, когда выяснилось, что он обладает невероятной магической силой…",
                genres = listOf(
                    ApiGenre.FANTASY,
                    ApiGenre.DRAMA,
                    ApiGenre.CRIME,
                    ApiGenre.DETECTIVE,
                ),
            ),
            ApiMovie(
                id = 448,
                localizedName = "Форрест Гамп",
                name = "Forrest Gump",
                year = 1994,
                rating = 8.921,
                imageUrl = "https://st.kp.yandex.net/images/film_iphone/iphone360_448.jpg",
                description = "От лица главного героя Форреста Гампа, слабоумного безобидного человека с благородным и открытым сердцем, рассказывается история его необыкновенной жизни. Фантастическим образом превращается он в известного футболиста, героя войны, преуспевающего бизнесмена. Он становится миллиардером, но остается таким же бесхитростным, глупым и добрым. Форреста ждет постоянный успех во всем, а он любит девочку, с которой дружил в детстве, но взаимность приходит слишком поздно.",
                genres = listOf(
                    ApiGenre.DRAMA,
                    ApiGenre.MELODRAMA,
                ),
            ),
        )
    )
}
