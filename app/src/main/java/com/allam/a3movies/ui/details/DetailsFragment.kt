package com.allam.a3movies.ui.details

import android.app.Activity
import android.app.Notification.EXTRA_TITLE
import android.content.Intent
import android.content.Intent.*
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat.EXTRA_TITLE
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.load
import com.allam.a3movies.R
import com.allam.a3movies.databinding.FragmentDetailsBinding
import com.allam.a3movies.db.MovieDatabase
import com.allam.a3movies.model.Movie
import com.allam.a3movies.ui.State
import com.allam.a3movies.util.FavoriteListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.*


@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val args: DetailsFragmentArgs by navArgs()

    private val detailsViewModel: DetailsViewModel by viewModels()

    private lateinit var binding: FragmentDetailsBinding

    lateinit var movie : Movie

    private var movieIsFavorite: Boolean = false

    lateinit var favoriteListener: FavoriteListener

    private val movieDatabase by lazy { context?.let { MovieDatabase.getDatabase(it).movieDao() } }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }



    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        return binding.root




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            detailsViewModel.getMovieDetail(args.movieId).collectLatest { state ->
                when (state) {
                    is State.Error -> {
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_LONG).show()
                    }
                    is State.Loading -> {
                        Toast.makeText(requireContext(), "Loading", Toast.LENGTH_LONG).show()
                    }
                    is State.Success -> {
                        setMovieDetails(state.data)
                    }
                }
            }


           /* var favButton: FloatingActionButton =  view.findViewById(R.id.fav_button)
            val titleAdded = getIntentOld("movie_title")

            favButton.setOnClickListener {
                val data = Intent()
                data.putExtra("title_added", titleAdded)
            // Close current window

            }

            fun changeFavoriteIcon(isFavorite: Boolean) {
                movieIsFavorite = isFavorite
                favButton.setImageResource(if (isFavorite) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24)
            }

            detailsViewModel.movieIsFavorite(movie!!.id.toString())
                .observe(viewLifecycleOwner, Observer {
                    changeFavoriteIcon(it.isNotEmpty())
                })


            favButton.setOnClickListener(this@DetailsFragment)*/

        }


    }

     private fun setMovieDetails(movie: Movie) {
        binding.nameMovie.text = movie.title
        binding.overviewMovie.text = movie.overView
        binding.releaseDateMovie.text = movie.release_date
        binding.voteAvMovie.text = movie.vote_average.toString()
        val imageUrl = "https://image.tmdb.org/t/p/w500/${movie.imageUrl}"
        binding.imageMovie.load(imageUrl)
    }






    /*override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.fav_button -> {
                detailsViewModel.saveFavorite(movie!!, !movieIsFavorite)
            }
        }
    }*/




}