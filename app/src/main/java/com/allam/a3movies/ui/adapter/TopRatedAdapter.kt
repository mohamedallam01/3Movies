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

        private var TopTxtTitle: TextView = view.findViewById(R.id.top_movie_name)
        private var TopImageMovie: ImageView = view.findViewById(R.id.top_rated_img)


        fun bindData(topRatedMovie: TopRatedMovie) {
            TopTxtTitle.text = topRatedMovie.TopTitle
            val imageUrl = "https://image.tmdb.org/t/p/w500/${topRatedMovie.TopImageUrl}"
            TopImageMovie.load(imageUrl)
            /*Top_image_movie.setOnClickListener {
                val action =
                   HomeFragmentDirections.actionHomeFragmentToDetailsFragment(movieId = topRatedMovie.id)
               Top_image_movie.findNavController().navigate(action)
           }*/






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

/*class TopRatedAdapter  constructor(
    private val topRatedList : List<TopRatedMovie>,
    private val context : Context
): BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var topRatedTitle: TextView
    private lateinit var topRatedImg: ImageView
    lateinit var topRatedMovie: TopRatedMovie

    override fun getCount(): Int {
        return topRatedList.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView

        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.card_view_item_grid, null)
        }

        topRatedTitle = convertView!!.findViewById(R.id.top_movie_name)
        topRatedImg = convertView!!.findViewById(R.id.top_rated_img)

        val imageUrl = "https://image.tmdb.org/t/p/w500/${topRatedMovie.TopImageUrl}"
        topRatedImg.load(imageUrl)

        topRatedTitle.text = topRatedList[position].toString()

        return convertView

    }*/