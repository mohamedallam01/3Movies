package com.allam.a3movies.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.allam.a3movies.model.Movie
import com.allam.a3movies.network.Resource
import com.allam.a3movies.repository.DetailsMovieRepo
import com.allam.a3movies.repository.MovieRepo
import com.allam.a3movies.ui.State
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: DetailsMovieRepo
) : ViewModel() {


    fun getMovieDetail(movieId: Int) = repository.getSingleMovie(movieId).map {
        State.fromResource(it)
    }


}