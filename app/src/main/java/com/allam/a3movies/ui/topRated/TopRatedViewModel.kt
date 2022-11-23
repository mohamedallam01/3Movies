package com.allam.a3movies.ui.topRated

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.allam.a3movies.repository.MovieRepo
import com.allam.a3movies.repository.TopRatedRepo
import com.allam.a3movies.ui.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltViewModel
class TopRatedViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: TopRatedRepo
) : ViewModel() {

    val topMovieData = repository.getAllTopRatedMovies().map {
        State.fromResource(it)
    }
}