package com.sequeniatest.movies.domain

sealed interface LoadableResult<R> {
    class Loading<R> : LoadableResult<R>

    class Success<R>(
        val value: R,
    ) : LoadableResult<R>

    class Failure<R> : LoadableResult<R>
}
