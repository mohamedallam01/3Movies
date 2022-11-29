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
    abstract fun topDao() : TopDao

    companion object {
        @Volatile
        private var INSTANCE2: TopDatabase? = null



        fun getTopDatabase (context: Context): TopDatabase {
            val tempInstance2 = INSTANCE2
            if (tempInstance2 != null) {
                return tempInstance2
            }

            synchronized(this) {
                val instance2 = Room.databaseBuilder(
                    context.applicationContext,
                    TopDatabase::class.java,
                    "top_movie_database"
                ).build()
                INSTANCE2 = instance2
                return instance2
            }

        }
    }


}
