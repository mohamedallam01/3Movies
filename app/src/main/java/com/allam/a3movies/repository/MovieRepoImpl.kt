package com.allam.a3movies.repository

import com.allam.a3movies.db.MovieDao
import com.allam.a3movies.model.Movie
import com.allam.a3movies.model.MoviesResponse
import com.allam.a3movies.network.NetworkBoundRepository
import com.allam.a3movies.network.Resource
import com.allam.a3movies.network.api.MoviesService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject


@ExperimentalCoroutinesApi
class MovieRepoImp @Inject constructor(
    private val movieDao: MovieDao,
    private val moviesService: MoviesService
) : MovieRepo {

    override fun getAllMovies(): Flow<Resource<List<Movie>>> {
        return object : NetworkBoundRepository<List<Movie>, MoviesResponse>() {
            override fun fetchFromLocal(): Flow<List<Movie>> = movieDao.getAll()
            override suspend fun fetchFromRemote(): Response<MoviesResponse> =
                moviesService.getPopularMovies()

            override suspend fun saveRemoteData(response: MoviesResponse) {
                movieDao.insertAll(response.moviesList)
            }
        }.asFlow()
    }
}
