package com.allam.a3movies.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.load
import com.allam.a3movies.R
import com.allam.a3movies.databinding.FragmentDetailsBinding
import com.allam.a3movies.databinding.FragmentHomeBinding
import com.allam.a3movies.model.Movie
import com.allam.a3movies.ui.State
import com.allam.a3movies.ui.adapter.MoviesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val args: DetailsFragmentArgs by navArgs()

    private val detailsViewModel: DetailsViewModel by viewModels()

    private lateinit var binding: FragmentDetailsBinding

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

        }
    }

    fun setMovieDetails(movie: Movie) {
        binding.nameMovie.text = movie.title
        binding.overviewMovie.text = movie.overView
        binding.releaseDateMovie.text = movie.release_date
        binding.voteAvMovie.text = movie.vote_average.toString()
        val imageUrl = "https://image.tmdb.org/t/p/w500/${movie.imageUrl}"
        binding.imageMovie.load(imageUrl)
    }


}