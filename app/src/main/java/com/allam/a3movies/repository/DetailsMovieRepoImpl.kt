package com.allam.a3movies.repository


import androidx.lifecycle.LiveData
import com.allam.a3movies.db.MovieDao
import com.allam.a3movies.db.TopDao
import com.allam.a3movies.model.Movie
import com.allam.a3movies.model.MoviesResponse
import com.allam.a3movies.model.TopRatedMovie
import com.allam.a3movies.network.NetworkBoundRepository
import com.allam.a3movies.network.Resource
import com.allam.a3movies.network.api.MoviesService
import com.allam.a3movies.network.api.TopMoviesService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class DetailsMovieRepoImpl @Inject constructor(
    private val movieDao: MovieDao,
    private val moviesService: MoviesService

) : DetailsMovieRepo {

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getSingleMovie(movieId: Int): Flow<Resource<Movie>> {
        return object : NetworkBoundRepository<Movie, Movie>() {
            override suspend fun saveRemoteData(response: Movie) {
                movieDao.insert(response)
            }

            override fun fetchFromLocal(): Flow<Movie> {
                return movieDao.getMovieById(movieId)
            }

            override suspend fun fetchFromRemote(): Response<Movie> {
                return moviesService.getSingleMovie(movieId)
            }


        }.asFlow()


    }

}


