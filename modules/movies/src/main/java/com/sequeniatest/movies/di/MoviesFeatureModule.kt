package com.sequeniatest.movies.di

import com.sequeniatest.movies.data.mapper.MoviesMapper
import com.sequeniatest.movies.data.repository.MoviesRepositoryImpl
import com.sequeniatest.movies.domain.repository.MoviesRepository
import com.sequeniatest.movies.domain.usecases.GetMoviesUseCase
import com.sequeniatest.movies.presentation.movies.MoviesViewModel
import com.sequeniatest.movies.presentation.movies.mapper.MoviesUiStateMapper
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val moviesFeatureModule = module {

    single { provideRetrofit() }
    single { provideMoviesApiService(get()) }

    factoryOf(::MoviesMapper)
    factoryOf(::MoviesRepositoryImpl) { bind<MoviesRepository>() }
    factoryOf(::GetMoviesUseCase)
    factoryOf(::MoviesUiStateMapper)

    viewModel {
        MoviesViewModel(
            mapper = get(),
            getMoviesUseCase = get(),
        )
    }
}
