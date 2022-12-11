package com.allam.a3movies.db

import android.content.Context
import androidx.room.*
import com.allam.a3movies.model.Movie
import com.allam.a3movies.ui.details.DetailsFragment
import com.allam.a3movies.util.MovieConverters
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized


@Database(entities = [Movie::class], version = 1, exportSchema = false)
@TypeConverters(MovieConverters::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao



    companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null



        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): MovieDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "movie_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }
}