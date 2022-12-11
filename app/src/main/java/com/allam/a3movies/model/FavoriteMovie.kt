package com.allam.a3movies.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
data class FavoriteMovie(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") var id: Int = 0,
    @ColumnInfo(name = "title")
    @SerializedName("title") var title: String? = null,
    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path") var imageUrl: String? = null,
    @ColumnInfo(name = "overview")
    @SerializedName("overview") var overView: String? = null,
    @ColumnInfo(name = "release_date")
    @SerializedName("release_date") var release_date: String? = null,
    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average") var vote_average: Float = 0.0f,
)
