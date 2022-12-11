package com.allam.a3movies.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.allam.a3movies.model.Movie
import com.allam.a3movies.network.Resource
import kotlinx.coroutines.flow.Flow


@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    fun getAll(): Flow<List<Movie>>

    @Insert
    suspend fun insertAll(movies: List<Movie>)

    @Insert
    suspend fun insert(movies: Movie)

    @Query("SELECT * FROM movies WHERE ID = :movieId")
    fun getMovieById(movieId: Int): Flow<Movie>
}