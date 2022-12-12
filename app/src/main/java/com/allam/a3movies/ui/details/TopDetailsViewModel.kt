package com.allam.a3movies.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.allam.a3movies.repository.DetailsMovieRepo
import com.allam.a3movies.repository.TopDetailsRepo
import com.allam.a3movies.ui.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class TopDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: TopDetailsRepo
) : ViewModel() {


    fun getTopMovieDetails(topId: Int) =repository.getTopSingle(topId).map {
        State.fromResource(it)
    }
}