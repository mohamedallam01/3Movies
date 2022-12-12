package com.allam.a3movies.repository

import androidx.lifecycle.LiveData
import com.allam.a3movies.model.Movie
import com.allam.a3movies.model.TopRatedMovie
import com.allam.a3movies.network.Resource
import kotlinx.coroutines.flow.Flow

interface DetailsMovieRepo {

    fun getSingleMovie(movieId: Int): Flow<Resource<Movie>>



}