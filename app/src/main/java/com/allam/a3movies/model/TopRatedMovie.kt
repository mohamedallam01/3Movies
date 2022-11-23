package com.allam.a3movies.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "top_rated")
data class TopRatedMovie(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") var TopId: Int = 0,
    @ColumnInfo(name = "title")
    @SerializedName("title") var TopTitle: String? = null,
    @ColumnInfo(name = "backdrop_path")
    @SerializedName("backdrop_path") var TopImageUrl: String? = null,
    @ColumnInfo(name = "overview")
    @SerializedName("overview") var TopOverView: String? = null,
    @ColumnInfo(name = "release_date")
    @SerializedName("release_date") var TopReleaseDate: String? = null,
    @ColumnInfo(name = "vote_average")
    @SerializedName("vote_average") var TopVoteAverage: Float = 0.0f,
)
