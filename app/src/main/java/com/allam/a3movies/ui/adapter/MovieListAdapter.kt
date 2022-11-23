package com.allam.a3movies.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.allam.a3movies.R
import com.allam.a3movies.model.Movie
import com.allam.a3movies.ui.home.HomeFragmentDirections


class MoviesAdapter() : ListAdapter<Movie, MoviesAdapter.MovieViewHolder>(MovieDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)

        )




    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }


    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var txtTitle: TextView = view.findViewById(R.id.movie_name)
        var txtReDate: TextView = view.findViewById(R.id.redate_movie)
        var txtVoteAv: TextView = view.findViewById(R.id.voteAV_movie)
        var image_movie: ImageView = view.findViewById(R.id.movie_image)


        fun bindData(movie: Movie) {
            txtTitle.text = movie.title
            txtReDate.text = movie.release_date
            txtVoteAv.text = movie.vote_average.toString()
            val imageUrl = "https://image.tmdb.org/t/p/w500/${movie.imageUrl}"
            image_movie.load(imageUrl)
            image_movie.setOnClickListener {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToDetailsFragment(movieId = movie.id)
                image_movie.findNavController().navigate(action)
            }






        }
    }




    class MovieDiffUtil : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }
    }

}
