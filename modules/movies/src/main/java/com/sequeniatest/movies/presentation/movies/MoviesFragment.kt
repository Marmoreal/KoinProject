package com.sequeniatest.movies.presentation.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import com.sequeniatest.movies.databinding.FragmentMoviesBinding
import com.sequeniatest.movies.presentation.movies.adapters.GenresAdapter
import com.sequeniatest.movies.presentation.movies.adapters.MoviesContentAdapter
import com.sequeniatest.movies.presentation.movies.extension.fitBottomInsetsWithPadding
import com.sequeniatest.movies.presentation.movies.extension.fitInsetsWithPadding
import com.sequeniatest.movies.presentation.movies.model.MoviesUiState.Error
import com.sequeniatest.movies.presentation.movies.model.MoviesUiState.Loading
import com.sequeniatest.movies.presentation.movies.model.MoviesUiState.Success
import com.sequeniatest.movies.presentation.movies.model.UiGenre
import com.sequeniatest.movies.presentation.movies.model.UiMovie
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding
    private val viewModel: MoviesViewModel by viewModel()

    private val genresAdapter = GenresAdapter()
    private val moviesContentAdapter = MoviesContentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupLayout()
        onBindViewModel()
    }

    private fun setupLayout() {
        binding.toolbar.fitInsetsWithPadding()
        binding.recyclerViewContent.fitBottomInsetsWithPadding()

        initAdapters()
    }

    private fun initAdapters() {
        genresAdapter.onGenreClick = {
            viewModel.filterMoviesByGenre(it)
        }
        moviesContentAdapter.onMovieClick = {
            viewModel.openMovie(it)
        }
        binding.recyclerViewContent.adapter = ConcatAdapter(
            genresAdapter,
            moviesContentAdapter,
        )
    }

    private fun onBindViewModel() {
        lifecycleScope.launch {
            viewModel.state.collect { state ->
                when (state) {
                    is Loading -> {
                        binding.progressBar.isVisible = true
                    }
                    is Success -> {
                        binding.progressBar.isVisible = false
                        bindGenres(state.genres)
                        bindMovies(state.movies)
                    }
                    is Error -> {
                        binding.progressBar.isVisible = false
                    }
                }
            }
        }
    }

    private fun bindGenres(genres: List<UiGenre>) {
        genresAdapter.submitList(genres)
    }

    private fun bindMovies(movie: List<UiMovie>) {
        moviesContentAdapter.submitList(movie)
    }

    override fun onDestroyView() {
        binding.recyclerViewContent.adapter = null
        super.onDestroyView()
    }
}
