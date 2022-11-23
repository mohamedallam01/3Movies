package com.allam.a3movies.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

data class TopRatedMovieResponse(
    @ColumnInfo(name = "page")
    @SerializedName("page") var page: Int = 0,
    @ColumnInfo(name = "results")
    @SerializedName("results") var topRatedList : List<TopRatedMovie>,
    @SerializedName("total_pages") var totalPages: Int = 0,
    @ColumnInfo(name = "total_results")
    @SerializedName("total_results") var total_results: Int = 0,
)
