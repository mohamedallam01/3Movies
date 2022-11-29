package com.allam.a3movies.ui.topRated

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.allam.a3movies.repository.MovieRepo
import com.allam.a3movies.repository.TopRatedRepo
import com.allam.a3movies.ui.State
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltViewModel
open class TopRatedViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val topRepository: TopRatedRepo
) : ViewModel() {

    val topMovieData = topRepository.getAllTopRatedMovies().map {
        State.fromResource(it)
    }
}