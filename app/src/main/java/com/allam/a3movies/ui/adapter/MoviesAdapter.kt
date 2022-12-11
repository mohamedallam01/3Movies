package com.allam.a3movies.ui.adapter

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
import com.allam.a3movies.util.FavoriteListener


class MoviesAdapter() : ListAdapter<Movie, MoviesAdapter.MovieViewHolder>(MovieDiffUtil()) {


    lateinit var favoriteListener: FavoriteListener




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val popView =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)



        /*val favView =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)*/

        return MovieViewHolder( popView)

    }





    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindDataPop(getItem(position))

       /* holder.bindDataFav(getItem(position), favoriteListener)*/
    }


    class MovieViewHolder( popView : View) : RecyclerView.ViewHolder(popView) {

        var txtTitle: TextView = popView.findViewById(R.id.movie_name)
        var txtReDate: TextView = popView.findViewById(R.id.redate_movie)
        private var txtVoteAv: TextView = popView.findViewById(R.id.voteAV_movie)
        private var imageMovie: ImageView = popView.findViewById(R.id.movie_image)
        fun bindDataPop(movie: Movie) {
            txtTitle.text = movie.title
            txtReDate.text = movie.release_date
            txtVoteAv.text = movie.vote_average.toString()

            val imageUrl = "https://image.tmdb.org/t/p/w500/${movie.imageUrl}"
            imageMovie.load(imageUrl)
            imageMovie.setOnClickListener {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToDetailsFragment(movieId = movie.id)
                imageMovie.findNavController().navigate(action)
            }

        }
        /*var favTxtTitle: TextView = favView.findViewById(R.id.movie_name)
        var favTxtReDate: TextView = favView.findViewById(R.id.redate_movie)
        private var favTxtVoteAv: TextView = favView.findViewById(R.id.voteAV_movie)
        private var favImageMovie: ImageView = favView.findViewById(R.id.movie_image)

        fun bindDataFav(movie: Movie, favoriteListener: FavoriteListener){
            favTxtTitle.text = movie.title
            favTxtReDate.text= movie.release_date
            favTxtVoteAv.text= movie.vote_average.toString()

            val favImageUrl = "https://image.tmdb.org/t/p/w500/${movie.imageUrl}"
            favImageMovie.load(favImageUrl)

        }*/
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
