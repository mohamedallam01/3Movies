package com.allam.a3movies.ui.favourites

import androidx.lifecycle.*
import com.allam.a3movies.model.FavoriteMovie
import com.allam.a3movies.model.Movie
import com.allam.a3movies.network.Resource
import com.allam.a3movies.repository.MovieRepo
import com.allam.a3movies.ui.State
import com.google.android.gms.common.api.Status
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class FavouritesViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val repository : MovieRepo
): ViewModel() {

    val favMovieData =
        repository.getAllMovies().map {
            State.fromResource(it)


        }
}