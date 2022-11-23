package com.allam.a3movies.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.allam.a3movies.model.Movie
import com.allam.a3movies.model.TopRatedMovie
import kotlinx.coroutines.flow.Flow

@Dao
interface TopDao {
    @Query("SELECT * FROM top_rated")
    fun getAllTop(): Flow<List<TopRatedMovie>>

    @Insert
    suspend fun insertAllTop(top_rated: List<TopRatedMovie>)

    @Insert
    suspend fun insertTop(top_rated: TopRatedMovie)

    @Query("SELECT * FROM top_rated WHERE TopID = :TopId")
    fun getTopMovieById(TopId: Int): Flow<TopRatedMovie>
}