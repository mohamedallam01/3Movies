package com.allam.a3movies.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.allam.a3movies.model.Movie
import com.allam.a3movies.network.Resource
import com.allam.a3movies.repository.DetailsMovieRepo
import com.allam.a3movies.ui.State
import com.allam.a3movies.util.SingleLiveEvent
import com.google.android.gms.common.ConnectionResult.SUCCESS
import com.google.android.gms.common.api.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: DetailsMovieRepo,
) : ViewModel() {

     private val job = SupervisorJob()
     private val main: CoroutineDispatcher = Dispatchers.Main
    private val favoriteSavedState: SingleLiveEvent<Resource<Pair<Boolean, Boolean>>> =
        SingleLiveEvent()


    fun getMovieDetail(movieId: Int) = repository.getSingleMovie(movieId).map {
        State.fromResource(it)
    }

    /*fun movieIsFavorite(id: String): LiveData<List<Movie>> = repository.existAsFavorite(id)

    @OptIn(DelicateCoroutinesApi::class)
    fun saveFavorite(movie: Movie, favorite: Boolean) = GlobalScope.launch(main + job) {
        try {

            if (favorite) {
                repository.insert(movie)
            } else {
                repository.delete(movie)
            }

        }
        catch (e: Exception) {

        }
    }*/


}