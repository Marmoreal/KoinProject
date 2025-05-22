package com.sequeniatest.movies.domain

sealed interface LoadableResult<R> {
    class Loading<R> : LoadableResult<R>

    class Success<R>(
        val value: R,
    ) : LoadableResult<R>

    class Failure<R> : LoadableResult<R>

    val isLoading: Boolean get() = this is Loading

    val isSuccess: Boolean get() = this is Success

    val isFailure: Boolean get() = this is Failure
}
