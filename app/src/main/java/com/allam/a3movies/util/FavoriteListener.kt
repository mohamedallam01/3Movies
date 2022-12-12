package com.allam.a3movies.util

import android.widget.ImageView
import com.allam.a3movies.model.Movie

interface FavoriteListener {

    fun onClickRetry()

    fun onMovieClick(movieResult: Movie, pos: Int)
}