package com.allam.a3movies.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.allam.a3movies.model.Movie
import com.allam.a3movies.model.TopRatedMovie
import kotlinx.coroutines.InternalCoroutinesApi

@Database(entities = [TopRatedMovie::class], version = 1, exportSchema = false)
abstract class TopDatabase: RoomDatabase() {

    abstract fun topMovieDao() : TopDao

    companion object {
        @Volatile
        private var INSTANCE: TopDatabase? = null



        fun getTopDatabase (context: Context): TopDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TopDatabase::class.java,
                    "top_movie_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }


}
