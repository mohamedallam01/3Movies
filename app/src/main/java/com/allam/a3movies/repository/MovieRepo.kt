package com.allam.a3movies.repository

import com.allam.a3movies.model.Movie
import com.allam.a3movies.network.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepo {
    fun getAllMovies(): Flow<Resource<List<Movie>>>
}