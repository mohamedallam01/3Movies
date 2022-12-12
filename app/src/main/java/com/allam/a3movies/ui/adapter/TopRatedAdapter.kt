package com.allam.a3movies.ui.adapter

import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.allam.a3movies.R
import com.allam.a3movies.model.Movie
import com.allam.a3movies.model.TopRatedMovie
import com.allam.a3movies.ui.home.HomeFragmentDirections
import com.allam.a3movies.ui.topRated.TopRatedFragmentDirections
import com.allam.a3movies.ui.topRated.TopRatedViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi


class TopRatedAdapter() : ListAdapter<TopRatedMovie, TopRatedAdapter.TopRatedViewHolder>(TopRatedDiffUtil()) {

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder =
        TopRatedViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_grid, parent, false)

        )


    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        holder.bindData(getItem(position) as TopRatedMovie)
    }

    class TopRatedViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var topTxtTitle: TextView = view.findViewById(R.id.top_movie_name)
        private var topImageMovie: ImageView = view.findViewById(R.id.top_rated_img)


        fun bindData(topRatedMovie: TopRatedMovie) {
            topTxtTitle.text = topRatedMovie.TopTitle
            val imageUrl = "https://image.tmdb.org/t/p/w500/${topRatedMovie.TopImageUrl}"
            topImageMovie.load(imageUrl)
            topImageMovie.setOnClickListener {
                val action =
                    TopRatedFragmentDirections.actionTopRatedFragmentToTopDetails(topId = topRatedMovie.TopId)
                topImageMovie.findNavController().navigate(action)
            }







        }
    }

    class TopRatedDiffUtil : DiffUtil.ItemCallback<TopRatedMovie>() {
        override fun areItemsTheSame(oldItem: TopRatedMovie, newItem: TopRatedMovie): Boolean {
            return oldItem.TopId == newItem.TopId
        }

        override fun areContentsTheSame(oldItem: TopRatedMovie, newItem: TopRatedMovie): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }
    }

}
