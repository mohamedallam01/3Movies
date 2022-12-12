package com.allam.a3movies.repository

import com.allam.a3movies.db.TopDao
import com.allam.a3movies.model.Movie
import com.allam.a3movies.model.MoviesResponse
import com.allam.a3movies.model.TopRatedMovie
import com.allam.a3movies.model.TopRatedMovieResponse
import com.allam.a3movies.network.NetworkBoundRepository
import com.allam.a3movies.network.Resource
import com.allam.a3movies.network.api.TopMoviesService
import io.grpc.internal.SharedResourceHolder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import java.security.PrivateKey
import javax.inject.Inject


@ExperimentalCoroutinesApi
class TopRatedImpl @Inject constructor(
    private val topDao : TopDao,
    private val topMoviesService : TopMoviesService

) : TopRatedRepo{

    override fun getAllTopRatedMovies(): Flow<Resource<List<TopRatedMovie>>> {
        return object : NetworkBoundRepository<List<TopRatedMovie>, TopRatedMovieResponse>() {
            override fun fetchFromLocal(): Flow<List<TopRatedMovie>> = topDao.getAllTop()
            override suspend fun fetchFromRemote(): Response<TopRatedMovieResponse> =
                topMoviesService.getTopRatedMovies()

            override suspend fun saveRemoteData(response: TopRatedMovieResponse) {
                topDao.insertAllTop(response.topRatedList)
            }
        }.asFlow()
    }
}