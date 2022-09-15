package com.allam.a3movies.network.api

import com.allam.a3movies.model.Movie
import com.allam.a3movies.model.MoviesResponse
import com.allam.a3movies.util.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MoviesService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") key: String = API_KEY): Response<MoviesResponse>

    @GET("movie/{movieId}")
    suspend fun getSingleMovie(
        @Path("movieId") id: Int,
        @Query("api_key") key: String = API_KEY
    ): Response<Movie>
}