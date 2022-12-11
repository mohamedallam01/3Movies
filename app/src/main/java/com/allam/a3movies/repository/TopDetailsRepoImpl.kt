package com.allam.a3movies.repository

import com.allam.a3movies.db.TopDao
import com.allam.a3movies.model.TopRatedMovie
import com.allam.a3movies.network.NetworkBoundRepository
import com.allam.a3movies.network.Resource
import com.allam.a3movies.network.api.TopMoviesService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class TopDetailsRepoImpl @Inject constructor(
    private val topMovieDao : TopDao,
    private val topMoviesService : TopMoviesService
) :TopDetailsRepo {

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getTopSingle(topId: Int): Flow<Resource<TopRatedMovie>> {
        return object : NetworkBoundRepository<TopRatedMovie, TopRatedMovie>() {
            override suspend fun saveRemoteData(response: TopRatedMovie) {
                topMovieDao.insertTop(response)
            }

            override fun fetchFromLocal(): Flow<TopRatedMovie> {
                return topMovieDao.getTopMovieById(topId)
            }

            override suspend fun fetchFromRemote(): Response<TopRatedMovie> {
                return topMoviesService.getTopSingleMovie(topId)
            }


        }.asFlow()


    }

}