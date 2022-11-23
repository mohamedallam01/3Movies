package com.allam.a3movies.di.module

import com.allam.a3movies.db.MovieDao
import com.allam.a3movies.db.TopDao
import com.allam.a3movies.network.api.MoviesService
import com.allam.a3movies.network.api.TopMoviesService
import com.allam.a3movies.repository.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(movieDao: MovieDao, moviesService: MoviesService): MovieRepo =
        MovieRepoImp(movieDao, moviesService)

    @Singleton
    @Provides
    fun provideDetailsRepository(
        movieDao: MovieDao,
        moviesService: MoviesService
    ): DetailsMovieRepo =
        DetailsMovieRepoImpl(movieDao, moviesService)


    @OptIn(ExperimentalCoroutinesApi::class)
    @Singleton
    @Provides
    fun provideTopMovieRepository(topMovieDao : TopDao, topMoviesService: TopMoviesService): TopRatedRepo =
        TopRatedImpl(topMovieDao, topMoviesService)


}