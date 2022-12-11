package com.allam.a3movies.repository

import com.allam.a3movies.model.TopRatedMovie
import com.allam.a3movies.network.Resource
import kotlinx.coroutines.flow.Flow

interface TopDetailsRepo {

    fun getTopSingle(topId: Int) : Flow<Resource<TopRatedMovie>>
}