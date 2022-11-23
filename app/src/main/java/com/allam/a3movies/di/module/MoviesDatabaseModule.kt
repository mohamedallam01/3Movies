package com.allam.a3movies.di.module

import android.app.Application
import com.allam.a3movies.db.MovieDatabase
import com.allam.a3movies.db.TopDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MoviesDatabaseModule {


    @Singleton
    @Provides
    fun provideDatabase(application: Application) = MovieDatabase.getDatabase(application)

    @Singleton
    @Provides
    fun provideMoviesDao(database: MovieDatabase) = database.movieDao()

    @Singleton
    @Provides
    fun provideTopDatabase(application: Application) = TopDatabase.getTopDatabase(application)

    @Singleton
    @Provides
    fun provideTopMoviesDao(database: TopDatabase) = database.topMovieDao()


}

