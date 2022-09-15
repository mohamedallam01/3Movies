package com.allam.a3movies.ui.home


import androidx.lifecycle.*
import com.allam.a3movies.model.Movie
import com.allam.a3movies.network.Resource
import com.allam.a3movies.repository.MovieRepo
import com.allam.a3movies.ui.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.map
import java.lang.Float
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltViewModel
open class HomeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: MovieRepo
) : ViewModel() {


    val movieData = repository.getAllMovies().map {
        State.fromResource(it)
    }

}