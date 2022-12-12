package com.allam.a3movies.network.api

import com.allam.a3movies.model.TopRatedMovie
import com.allam.a3movies.model.TopRatedMovieResponse
import com.allam.a3movies.util.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TopMoviesService {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key") key: String = API_KEY): Response<TopRatedMovieResponse>

    @GET("movie/{topID}")
    suspend fun getTopSingleMovie(
        @Path("topID") id: Int,
        @Query("api_key") key: String = API_KEY
    ): Response<TopRatedMovie>
}