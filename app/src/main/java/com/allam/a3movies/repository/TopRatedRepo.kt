package com.allam.a3movies.repository

import com.allam.a3movies.model.TopRatedMovie
import com.allam.a3movies.network.Resource
import kotlinx.coroutines.flow.Flow


interface TopRatedRepo {
    fun getAllTopRatedMovies() : Flow<Resource<List<TopRatedMovie>>>
}